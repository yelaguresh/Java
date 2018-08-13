package imcs.trng.util;

import java.util.List;

import org.hibernate.transform.ResultTransformer;

import imcs.trng.pojo.ReportBean;

public class ReportResultTransformer implements ResultTransformer {

	private static final long serialVersionUID = 1L;

	public Object transformTuple(Object[] paramArrayOfObject, String[] paramArrayOfString) {
		ReportBean rptBean = new ReportBean();
		rptBean.setCustomerId((int) paramArrayOfObject[0]);
		rptBean.setCustomerName((String) paramArrayOfObject[1]);
		rptBean.setPriceEach((double) paramArrayOfObject[2]);
		rptBean.setQuantityOrdered((int) paramArrayOfObject[3]);

		return rptBean;
	}

	public List transformList(List paramList) {
		return paramList;
	}

}
