package com.jas.facade;

import com.jas.request.CommonRequest;
import com.jas.vo.ComplexVO;
import com.jas.vo.CustomVO;

/**
 * ICustomFacade
 *
 * @author lanxiang
 * @since 2019-09-10
 */
public interface ICustomFacade {

    CustomVO getTest(CommonRequest commonRequest);

    boolean insertTest(CommonRequest commonRequest);

    ComplexVO complexTest(CommonRequest commonRequest);
}
