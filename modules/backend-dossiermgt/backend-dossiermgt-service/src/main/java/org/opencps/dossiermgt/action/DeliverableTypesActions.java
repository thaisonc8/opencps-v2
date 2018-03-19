package org.opencps.dossiermgt.action;

import org.opencps.dossiermgt.model.DeliverableType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ServiceContext;

public interface DeliverableTypesActions {

	public JSONObject getDeliverableTypes(long groupId, int start, int end);

	public DeliverableType addDeliverableType(long groupId, String deliverableName, String deliverableType_, String codePattern,
			String counter, String formScript, String formReport, String mappingData, ServiceContext serviceContext)
			throws PortalException, SystemException;

	public DeliverableType updateDeliverableType(long groupId, long deliverableTypeId, String deliverableName,
			String deliverableType_, String codePattern, String counter, String formScript, String formReport,
			String mappingData, ServiceContext serviceContext) throws SystemException, PortalException;

	public DeliverableType removeDeliverableType(long groupId, String deliverableTypeId)
			throws PortalException;

	public DeliverableType updateDeliverableTypeFormScript(long groupId, long deliverableTypeId, String formScript,
			ServiceContext serviceContext) throws SystemException, PortalException;

	public DeliverableType updateDeliverableTypeFormReport(long groupId, long deliverableTypeId, String formReport,
			ServiceContext serviceContext) throws SystemException, PortalException;

	public DeliverableType updateDeliverableTypeMappingData(long groupId, long deliverableTypeId, String mappingData,
			ServiceContext serviceContext) throws SystemException, PortalException;

}
