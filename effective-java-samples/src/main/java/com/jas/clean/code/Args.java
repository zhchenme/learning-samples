package com.jas.clean.code;

import java.util.*;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2021/06/09
 */
public class Args {

    private Map<Character, ArgumentMarshaler> marshalers;

    private Set<Character> argsFound;

    private ListIterator<String> currentArgument;

    public Args(String schema, String[] args) {
        marshalers = new HashMap<Character, ArgumentMarshaler>();
        argsFound = new HashSet<Character>();
        parseSchema(schema);
        parseArgumentStrings(Arrays.asList(args));
    }

    private void parseSchema(String schema) {
        for (String element : schema.split(",")) {
            if (element.length() > 0) {
                parseSchemaElement(element.trim());
            }
        }
    }

    private void parseSchemaElement(String element) {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        if (elementTail.length() == 0) {
            marshalers.put(elementId, new BooleanArgumentMarshaler());
        } else if (elementTail.equals("*")) {
            marshalers.put(elementId, new StringArgumentMarshaler());
        } else if (elementTail.equals("#")) {
            marshalers.put(elementId, new IntegerArgumentMarshaler());
        } else {
            throw new IllegalArgumentException("invalid argument format" + " " + elementId + " " + elementTail);
        }
    }

    private void validateSchemaElementId(char elementId) {
        if (!Character.isLetter(elementId)) {
            throw new IllegalArgumentException("invalid argument name");
        }
    }

    private void parseArgumentStrings(List<String> argsList) {
        for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {
            String argString = currentArgument.next();
            if (argString.startsWith("-")) {
                parseArgumentCharacters(argString.substring(1));
            } else {
                currentArgument.previous();
                break;
            }
        }
    }

    private void parseArgumentCharacters(String argChars) {
        for (int i = 0; i < argChars.length(); i++) {
            parseArgumentCharacter(argChars.charAt(i));
        }
    }

    private void parseArgumentCharacter(char argChar) {
        ArgumentMarshaler am = marshalers.get(argChar);
        if (null == am) {
            throw new IllegalArgumentException("unexpected argument" + " " + argChar);
        } else {
            argsFound.add(argChar);
            am.set(currentArgument);
        }
    }

    public boolean has(char arg) {
        return argsFound.contains(arg);
    }

    public boolean getBoolean(char arg) {
        return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public String getString(char arg) {
        return StringArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public int getInt(char arg) {
        return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
    }
}
