package org.opencps.api.controller.util;

import java.io.File;
import java.util.List;

import org.opencps.api.constants.ConstantUtils;
import org.opencps.api.v21.model.ActionConfigList;
import org.opencps.api.v21.model.ActionConfigList.ActionConfig;
import org.opencps.api.v21.model.Actions;
import org.opencps.api.v21.model.Actions.ProcessAction;
import org.opencps.api.v21.model.Configs;
import org.opencps.api.v21.model.Configs.ServiceConfig;
import org.opencps.api.v21.model.DeliverableTypeList;
import org.opencps.api.v21.model.DeliverableTypeList.DeliverableType;
import org.opencps.api.v21.model.DictCollection;
import org.opencps.api.v21.model.DocumentTypeList;
import org.opencps.api.v21.model.DocumentTypeList.DocumentType;
import org.opencps.api.v21.model.DossierTemplate;
import org.opencps.api.v21.model.FileTemplates;
import org.opencps.api.v21.model.FileTemplates.FileTemplate;
import org.opencps.api.v21.model.MenuConfigList;
import org.opencps.api.v21.model.MenuConfigList.MenuConfig;
import org.opencps.api.v21.model.Parts;
import org.opencps.api.v21.model.Parts.DossierPart;
import org.opencps.api.v21.model.Processes;
import org.opencps.api.v21.model.Processes.ProcessOption;
import org.opencps.api.v21.model.ServiceInfo;
import org.opencps.api.v21.model.ServiceProcess;
import org.opencps.api.v21.model.ServiceProcess.Roles;
import org.opencps.api.v21.model.ServiceProcess.Roles.ProcessRole;
import org.opencps.api.v21.model.StepConfigList;
import org.opencps.api.v21.model.StepConfigList.StepConfig;
import org.opencps.api.v21.model.Steps;
import org.opencps.api.v21.model.Steps.ProcessStep;
import org.opencps.api.v21.model.Steps.ProcessStep.Roles.StepRole;
import org.opencps.dossiermgt.action.ActionConfigActions;
import org.opencps.dossiermgt.action.DeliverableTypesActions;
import org.opencps.dossiermgt.action.DocumentTypeActions;
import org.opencps.dossiermgt.action.DossierTemplateActions;
import org.opencps.dossiermgt.action.FileUploadUtils;
import org.opencps.dossiermgt.action.MenuConfigActions;
import org.opencps.dossiermgt.action.ServiceConfigActions;
import org.opencps.dossiermgt.action.ServiceInfoActions;
import org.opencps.dossiermgt.action.ServiceProcessActions;
import org.opencps.dossiermgt.action.StepConfigActions;
import org.opencps.dossiermgt.action.impl.ActionConfigActionsImpl;
import org.opencps.dossiermgt.action.impl.DeliverableTypesActionsImpl;
import org.opencps.dossiermgt.action.impl.DocumentTypeActionsImpl;
import org.opencps.dossiermgt.action.impl.DossierTemplateActionsImpl;
import org.opencps.dossiermgt.action.impl.MenuConfigActionsImpl;
import org.opencps.dossiermgt.action.impl.ServiceConfigActionImpl;
import org.opencps.dossiermgt.action.impl.ServiceInfoActionsImpl;
import org.opencps.dossiermgt.action.impl.ServiceProcessActionsImpl;
import org.opencps.dossiermgt.action.impl.StepConfigActionsImpl;
import org.opencps.dossiermgt.exception.NoSuchServiceConfigException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class ProcessUpdateDBUtils {

	private static Log _log = LogFactoryUtil.getLog(ProcessUpdateDBUtils.class);
	//LamTV_Update ActionConfig to DB
	public static void processUpdateActionConfig(ActionConfigList actList, String folderPath, long groupId,
			long userId, ServiceContext serviceContext) {
		try {
			if (actList != null) {
				List<ActionConfig> actConfigList = actList.getActionConfig();
				if (actConfigList != null && actConfigList.size() > 0) {
					for (ActionConfig actConfig : actConfigList) {
						String actionCode = actConfig.getActionCode();
						String actionName = actConfig.getActionName();
						Boolean extraForm = actConfig.isExtraForm();
						String sampleData = actConfig.getSampleData();
						Boolean insideProcess = actConfig.isInsideProcess();
						Integer syncType = actConfig.getSyncType();
						Boolean rollbackable = actConfig.isRollbackable();
						String notificationType = actConfig.getNotificationType();
						String documentType = actConfig.getDocumentType();
						if (Validator.isNotNull(actionCode)) {
							String filePath = folderPath + ConstantUtils.SOURCE_FORMS + StringPool.FORWARD_SLASH + ConstantUtils.PREFIX_ACTIONCONFIG
									+ actionCode + ConstantUtils.EXTENTION_JSON;
							File jsonfile = new File(filePath);
							String formConfig = StringPool.BLANK;
							if (jsonfile.exists() && !jsonfile.isDirectory()) {
								formConfig = ReadXMLFileUtils.convertFiletoString(jsonfile);
							}
							// Check record exits DB
							ActionConfigActions actions = new ActionConfigActionsImpl();
							actions.updateActionConfigDB(userId, groupId, actionCode, actionName, extraForm, sampleData, insideProcess,
									syncType, rollbackable, notificationType, documentType, formConfig);
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	//LamTV_Update StepConfig to DB
	public static void processUpdateStepConfig(StepConfigList stepList, long groupId,
			long userId, ServiceContext serviceContext) {
		try {
			if (stepList != null) {
				List<StepConfig> stepConfigList = stepList.getStepConfig();
				if (stepConfigList != null && stepConfigList.size() > 0) {
					for (StepConfig stepConfig : stepConfigList) {
						String stepCode = stepConfig.getStepCode();
						String stepName = stepConfig.getStepName();
						Integer stepType = stepConfig.getStepType();
						String dossierStatus = stepConfig.getDossierStatus();
						String dossierSubStatus = stepConfig.getDossierSubStatus();
						String menuGroup = stepConfig.getMenuGroup();
						String menuStepName = stepConfig.getMenuStepName();
						String buttonConfig = stepConfig.getButtonConfig();
						if (Validator.isNotNull(stepCode)) {
							// Check record exits DB
							StepConfigActions actions = new StepConfigActionsImpl();
							actions.updateStepConfigDB(userId, groupId, stepCode, stepName, stepType, dossierStatus, dossierSubStatus,
									menuGroup, menuStepName, buttonConfig);
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	//LamTV_Update MenuConfig to DB
	public static void processUpdateMenuConfig(MenuConfigList menuList, long groupId,
			long userId, ServiceContext serviceContext) {
		try {
			if (menuList != null) {
				List<MenuConfig> menuConfigList = menuList.getMenuConfig();
				if (menuConfigList != null && menuConfigList.size() > 0) {
					for (MenuConfig menuConfig : menuConfigList) {
						String menuGroup = menuConfig.getMenuGroup();
						String menuName = menuConfig.getMenuName();
						Integer order = menuConfig.getOrder();
						Integer menuType = menuConfig.getMenuType();
						String queryParams = menuConfig.getQueryParams();
						String tableConfig = menuConfig.getTableConfig();
						String buttonConfig = menuConfig.getButtonConfig();
						if (Validator.isNotNull(menuGroup)) {
							// Check record exits DB
							MenuConfigActions actions = new MenuConfigActionsImpl();
							actions.updateMenuConfigDB(userId, groupId, menuGroup, menuName, order, menuType, queryParams,
									tableConfig, buttonConfig);
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	//LamTV_Update DocumentType to DB
	public static void processUpdateDocumentType(DocumentTypeList docList, String folderPath, long groupId,
			long userId, ServiceContext serviceContext) {
		try {
			if (docList != null) {
				List<DocumentType> docTypeList = docList.getDocumentType();
				if (docTypeList != null && docTypeList.size() > 0) {
					for (DocumentType docType : docTypeList) {
						String typeCode = docType.getTypeCode();
						Integer templateClass = docType.getTemplateClass();
						String documentName = docType.getDocumentName();
						String codePattern = docType.getCodePattern();
						Integer docSync = docType.getDocSync();
						if (Validator.isNotNull(typeCode)) {
							String filePath = folderPath + ConstantUtils.SOURCE_REPORTS + StringPool.FORWARD_SLASH
									+ typeCode + ConstantUtils.EXTENTION_XML;
							File xmlfile = new File(filePath);
							String documentScript = StringPool.BLANK;
							if (xmlfile.exists() && !xmlfile.isDirectory()) {
								documentScript = ReadXMLFileUtils.convertFiletoString(xmlfile);
							}
							// Check record exits DB
							DocumentTypeActions actions = new DocumentTypeActionsImpl();
							actions.updateDocumentTypeDB(userId, groupId, typeCode, templateClass, documentName, codePattern, docSync,
									documentScript);
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	//LamTV_Update DeliverableType to DB
	public static void processUpdateDeliverableType(DeliverableTypeList deliTypeList, String folderPath, long groupId,
			long userId, ServiceContext serviceContext) {
		try {
			if (deliTypeList != null) {
				List<DeliverableType> deliverableTypeList = deliTypeList.getDeliverableType();
				if (deliverableTypeList != null && deliverableTypeList.size() > 0) {
					for (DeliverableType deliType : deliverableTypeList) {
						String typeCode = deliType.getTypeCode();
						String typeName = deliType.getTypeName();
						String codePattern = deliType.getCodePattern();
						Integer docSync = deliType.getDocSync();
						String mappingData = deliType.getMappingData();
						String fieldConfigs = deliType.getFieldConfigs();
						if (Validator.isNotNull(typeCode)) {
							String filePathReport = folderPath + ConstantUtils.SOURCE_REPORTS + StringPool.FORWARD_SLASH
									+ typeCode + ConstantUtils.EXTENTION_XML;
							String filePathForm = folderPath + ConstantUtils.SOURCE_FORMS + StringPool.FORWARD_SLASH
									+ typeCode + ConstantUtils.EXTENTION_JSON;
							File xmlFile = new File(filePathReport);
							File jsonFile = new File(filePathForm);
							String formScript = StringPool.BLANK;
							String formReport = StringPool.BLANK;
							if (xmlFile.exists() && !xmlFile.isDirectory()) {
								formReport = ReadXMLFileUtils.convertFiletoString(xmlFile);
							}
							if (jsonFile.exists() && !jsonFile.isDirectory()) {
								formScript = ReadXMLFileUtils.convertFiletoString(jsonFile);
							}
							// Check record exits DB
							DeliverableTypesActions actions = new DeliverableTypesActionsImpl();
							actions.updateDeliverableTypeDB(userId, groupId, typeCode, typeName, codePattern, docSync, mappingData,
									fieldConfigs, formReport, formScript);
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	//LamTV_Update Dictcollection to DB
	public static void processUpdateDictCollection(DictCollection dicts) {
//		try {
//			if (dicts != null) {
//				String collectionCode = dicts.getCollectionCode();
//				String collectionName = dicts.getCollectionName();
//				String collectionNameEN = dicts.getCollectionNameEN();
//				String description = dicts.getDescription();
//				DictcollectionInterface actionCollection = new DictCollectionActions();
//				long dictCollectionId = actionCollection.updateDictCollectionDB(20164l, 55301l, collectionCode,
//						collectionName, collectionNameEN, description);
//				processUpdateDictItem(dictCollectionId, dicts, actionCollection);
//				
//				if (deliverableTypeList != null && deliverableTypeList.size() > 0) {
//					for (DeliverableType deliType : deliverableTypeList) {
//						String typeCode = deliType.getTypeCode();
//						String typeName = deliType.getTypeName();
//						String codePattern = deliType.getCodePattern();
//						Integer docSync = deliType.getDocSync();
//						String mappingData = deliType.getMappingData();
//						String fieldConfigs = deliType.getFieldConfigs();
//						if (Validator.isNotNull(typeCode)) {
//							String filePathReport = folderPath + ConstantUtils.SOURCE_REPORTS + StringPool.FORWARD_SLASH
//									+ typeCode + ConstantUtils.EXTENTION_XML;
//							String filePathForm = folderPath + ConstantUtils.SOURCE_REPORTS + StringPool.FORWARD_SLASH
//									+ typeCode + ConstantUtils.EXTENTION_JSON;
//							File xmlFile = new File(filePathReport);
//							File jsonFile = new File(filePathForm);
//							String formScript = StringPool.BLANK;
//							String formReport = StringPool.BLANK;
//							if (xmlFile.exists() && !xmlFile.isDirectory()) {
//								formReport = ReadXMLFile.convertFiletoString(xmlFile);
//							}
//							if (jsonFile.exists() && !jsonFile.isDirectory()) {
//								formScript = ReadXMLFile.convertFiletoString(jsonFile);
//							}
//							// Check record exits DB
//							DeliverableTypesActions actions = new DeliverableTypesActionsImpl();
//							actions.updateDeliverableTypeDB(20164l, 55301l, typeCode, typeName, codePattern, docSync, mappingData,
//									fieldConfigs, formReport, formScript);
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			_log.error(e);
//		}
	}

	//LamTV_ Process service to DB
	public static void processUpdateServiceInfo(ServiceInfo service, String folderPath, String folderParentPath,
			long groupId, long userId, ServiceContext serviceContext) {
		try {
			if (service != null) {
				String serviceCode = service.getServiceCode();
				String serviceName = service.getServiceName();
				String processText = service.getProcessText();
				String methodText = service.getMethodText();
				String dossierText = service.getDossierText();
				String conditionText = service.getConditionText();
				String durationText = service.getDurationText();
				String applicantText = service.getApplicantText();
				String resultText = service.getResultText();
				String regularText = service.getRegularText();
				String feeText = service.getFeeText();
				String administrationCode = service.getAdministrationCode();
				String administrationName = service.getAdministrationName();
				String domainCode = service.getDomainCode();
				String domainName = service.getDomainName();
				Integer maxLevel = service.getMaxLevel();
				// Update serviceInfo
				ServiceInfoActions actionService = new ServiceInfoActionsImpl();
				long serviceInfoId = actionService.updateServiceInfoDB(userId, groupId, serviceCode, serviceName, processText, methodText,
						dossierText, conditionText, durationText, applicantText, resultText, regularText, feeText,
						administrationCode, administrationName, domainCode, domainName, maxLevel);
				// Update fileName
				FileTemplates fileTemplate = service.getFileTemplates();
				if (fileTemplate != null) {
					processFileTemplate(userId, groupId, serviceInfoId, fileTemplate, folderParentPath, actionService, serviceContext);
				}
				// Add serviceConfig
				Configs configs = service.getConfigs();
				if (configs != null) {
					processServiceConfig(userId, groupId, serviceInfoId, configs, actionService, serviceContext);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	//LamTV_Process service to DB
	public static void processUpdateDossierTemplate(DossierTemplate template, String folderPath, String folderParentPath, long groupId,
			long userId, ServiceContext serviceContext) {
		try {
			if (template != null) {
				String templateNo = template.getTemplateNo();
				String templateName = template.getTemplateName();
				String description = template.getDescription();
				// Update serviceInfo
				DossierTemplateActions actionTemp = new DossierTemplateActionsImpl();
				actionTemp.updateDossierTemplateDB(userId, groupId, templateNo, templateName, description, serviceContext);
				// Update fileName
				Parts parts = template.getParts();
				if (parts != null) {
					processDossierPart(userId, groupId, parts, actionTemp, folderParentPath, templateNo,
							serviceContext);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public static void processUpdateServiceProcess(ServiceProcess process, String folderPath, long groupId,
			long userId, ServiceContext serviceContext) {
		try {
			if (process != null) {
				String processNo = process.getProcessNo();
				String processName = process.getProcessName();
				String description = process.getDescription();
				Integer durationCount = process.getDurationCount();
				Integer durationUnit = process.getDurationUnit();
				boolean generatePassword = process.isGeneratePassword();
				String serverNo = process.getServerNo();
				String serverName = process.getServerName();
				String dossierNoPattern = process.getDossierNoPattern();
				String dueDatePattern = process.getDueDatePattern();
				// Update serviceInfo
				ServiceProcessActions actionService = new ServiceProcessActionsImpl();
				long serviceProcessId = actionService.updateServiceProcessDB(userId, groupId, processNo, processName,
						description, durationCount, durationUnit, generatePassword, serverNo, serverName,
						dossierNoPattern, dueDatePattern, serviceContext);
				//Delete all record ServiceFileTemplate with serviceInfoId
				Roles processRoles = process.getRoles();
				if (processRoles != null) {
					processProcessRole(userId, groupId, serviceProcessId, processRoles, actionService, serviceContext);
				}
				// Process step
				Steps steps = process.getSteps();
				if (steps != null) {
					processProcessStep(userId, groupId, serviceProcessId, steps, actionService, serviceContext);
				}
				// Process actions
				Actions actions = process.getActions();
				if (actions != null) {
					processProcessAction(userId, groupId, serviceProcessId, actions, actionService, serviceContext);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	//LamTV_ Process output ServiceFileTemplate to DB
	private static void processFileTemplate(long userId, long groupId, long serviceInfoId, FileTemplates fileTemplate,
			String folderParentPath, ServiceInfoActions actionService, ServiceContext serviceContext) {
		List<FileTemplate> fileTempList = fileTemplate.getFileTemplate();
		if (fileTempList != null && fileTempList.size() > 0) {
			String fileTemplateNo = StringPool.BLANK;
			String fileTemplateName = StringPool.BLANK;
			String fileName = StringPool.BLANK;
			for (FileTemplate fileTemp : fileTempList) {
				fileTemplateNo = fileTemp.getFileTemplateNo();
				fileTemplateName = fileTemp.getTemplateName();
				fileName = fileTemp.getFilename();
				if (Validator.isNotNull(fileName)) {
					String filePathTemplate = folderParentPath + ConstantUtils.SOURCE_FILES + StringPool.FORWARD_SLASH
							+ fileName;
					File file = new File(filePathTemplate);
					FileEntry fileEntry = null;
					if (file.exists() && !file.isDirectory()) {
						try {
							fileEntry = FileUploadUtils.uploadDossierFile(userId, groupId, file, fileName, serviceContext);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if (fileEntry != null) {
						long fileEntryId = fileEntry.getFileEntryId();
						actionService.updateServiceFileTemplateDB(serviceInfoId, fileTemplateNo, fileTemplateName, fileName, fileEntryId);
					}
				}
			}
		}
	}

	//LamTV_Process output ServiceConfig to DB
	private static void processServiceConfig(long userId, long groupId, long serviceInfoId, Configs configs,
			ServiceInfoActions actionService, ServiceContext serviceContext) throws NoSuchServiceConfigException {
		List<ServiceConfig> configList = configs.getServiceConfig();
		if (configList != null && configList.size() > 0) {
			String govAgencyCode = StringPool.BLANK;
			String govAgencyName = StringPool.BLANK;
			String serviceInstruction = StringPool.BLANK;
			Integer serviceLevel = 0;
			String serviceUrl = StringPool.BLANK;
			boolean forCitizen = false;
			boolean forBusiness = false;
			boolean postalService = false;
			boolean registration = false;
			for (ServiceConfig config : configList) {
				govAgencyCode = config.getGovAgencyCode();
				govAgencyName = config.getGovAgencyName();
				serviceInstruction = config.getServiceInstruction();
				serviceLevel = config.getServiceLevel();
				serviceUrl = config.getServiceUrl();
				forCitizen = config.isForCitizen();
				forBusiness = config.isForBusiness();
				postalService = config.isPostalService();
				registration = config.isRegistration();
				//
				ServiceConfigActions actionConfig = new ServiceConfigActionImpl();
				
				long serviceConfigId = actionConfig.updateServiceConfigDB(userId, groupId, serviceInfoId, govAgencyCode, govAgencyName,
						serviceInstruction, serviceLevel, serviceUrl, forCitizen, forBusiness, postalService, registration, serviceContext);
				// Process ProcessOption
				if (serviceConfigId > 0) {
					Processes process = config.getProcesses();
					if (process != null) {
						processProcessOption(userId, groupId, serviceConfigId, process, actionConfig,
								serviceContext);
						
					}
				}
			}
		}
	}

	//LamTV_Process output ProcessOption to DB
	private static void processProcessOption(long userId, long groupId, long serviceConfigId, Processes process,
			ServiceConfigActions actionConfig, ServiceContext serviceContext) {
		List<ProcessOption> optionList = process.getProcessOption();
		if (optionList != null && optionList.size() > 0) {
			String optionCode = StringPool.BLANK;
			String optionName = StringPool.BLANK;
			Integer seqOrder = 0;
			String autoSelect = StringPool.BLANK;
			String instructionNote = StringPool.BLANK;
			String submissionNote = StringPool.BLANK;
			String templateNo = StringPool.BLANK;
			String templateName = StringPool.BLANK;
			String processNo = StringPool.BLANK;
			String processName = StringPool.BLANK;
			String registerBookCode = StringPool.BLANK;
			for (ProcessOption option : optionList) {
				optionCode = option.getOptionCode();
				optionName = option.getOptionName();
				seqOrder = option.getSeqOrder();
				autoSelect = option.getAutoSelect();
				instructionNote = option.getInstructionNote();
				submissionNote = option.getSubmissionNote();
				templateNo = option.getTemplateNo();
				templateName = option.getTemplateName();
				processNo = option.getProcessNo();
				processName = option.getProcessName();
				registerBookCode = option.getRegisterBookCode();
				//
				actionConfig.updateOptionDB(userId, groupId, optionCode, optionName, serviceConfigId, seqOrder,
						autoSelect, instructionNote, submissionNote, templateNo, templateName, processNo, processName,
						registerBookCode, serviceContext);
			}
		}
	}

	//LamTV_Process DossierPart to DB
	private static void processDossierPart(long userId, long groupId, Parts parts, DossierTemplateActions actionTemp,
			String folderParentPath, String templateNo, ServiceContext serviceContext) throws PortalException {
		List<DossierPart> dossierPartList = parts.getDossierPart();
		if (dossierPartList != null && dossierPartList.size() > 0) {
			String partNo = StringPool.BLANK;
			String partName = StringPool.BLANK;
			String partTip = StringPool.BLANK;
			Integer partType = 0;
			boolean multiple = false;
			boolean required = false;
			boolean esign = false;
			String fileTemplateNo = StringPool.BLANK;
			String deliverableType = StringPool.BLANK;
			Integer deliverableAction = 0;
			boolean eForm = false;
			String sampleData = StringPool.BLANK;
			String formScript = StringPool.BLANK;
			String formReport = StringPool.BLANK;
			for (DossierPart dossierPart : dossierPartList) {
				partNo = dossierPart.getPartNo();
				partName = dossierPart.getPartName();
				partTip = dossierPart.getPartTip();
				partType = dossierPart.getPartType();
				multiple = dossierPart.isMultiple();
				required = dossierPart.isRequired();
				esign = dossierPart.isEsign();
				fileTemplateNo = dossierPart.getFileTemplateNo();
				deliverableType = dossierPart.getDeliverableType();
				deliverableAction = dossierPart.getDeliverableAction();
				eForm = dossierPart.isEForm();
				sampleData = dossierPart.getSampleData();
				//
				String filePathReport = folderParentPath + ConstantUtils.SOURCE_REPORTS + StringPool.FORWARD_SLASH
						+ templateNo + StringPool.UNDERLINE + partNo + ConstantUtils.EXTENTION_XML;
				String filePathForm = folderParentPath + ConstantUtils.SOURCE_FORMS + StringPool.FORWARD_SLASH
						+ templateNo + StringPool.UNDERLINE + partNo + ConstantUtils.EXTENTION_JSON;
				File xmlFile = new File(filePathReport);
				File jsonFile = new File(filePathForm);
				if (xmlFile.exists() && !xmlFile.isDirectory()) {
					formReport = ReadXMLFileUtils.convertFiletoString(xmlFile);
				}
				if (jsonFile.exists() && !jsonFile.isDirectory()) {
					formScript = ReadXMLFileUtils.convertFiletoString(jsonFile);
				}
				//
				actionTemp.updateDossierPartDB(userId, groupId, templateNo, partNo, partName, partTip, partType,
						multiple, formScript, formReport, required, esign, fileTemplateNo, deliverableType,
						deliverableAction, eForm, sampleData, serviceContext);
			}
		}
	}

	//LamTV_Process output ProcessAction to DB
	private static void processProcessAction(long userId, long groupId, long serviceProcessId, Actions actions,
			ServiceProcessActions actionService, ServiceContext serviceContext) throws PortalException {
		List<ProcessAction> processActionList = actions.getProcessAction();
		if (processActionList != null && processActionList.size() > 0) {
			String actionCode = StringPool.BLANK;
			String actionName = StringPool.BLANK;
			String preStepCode = StringPool.BLANK;
			String postStepCode = StringPool.BLANK;
			String autoEvent = StringPool.BLANK;
			String preCondition = StringPool.BLANK;
			boolean allowAssignUser = false;
			long assignUserId = 0;
			String assignUserName = StringPool.BLANK;
			Integer requestPayment = 0;
			String paymentFee = StringPool.BLANK;
			String createDossierFiles = StringPool.BLANK;
			String returnDossierFiles = StringPool.BLANK;
			boolean eSignature = false;
			String signatureType = StringPool.BLANK;
			String createDossiers = StringPool.BLANK;
			for (ProcessAction processAction : processActionList) {
				actionCode = processAction.getActionCode();
				actionName = processAction.getActionName();
				preStepCode = processAction.getPreStepCode();
				postStepCode = processAction.getPostStepCode();
				autoEvent = processAction.getAutoEvent();
				preCondition = processAction.getPreCondition();
				allowAssignUser = processAction.isAllowAssignUser();
				assignUserId = processAction.getAssignUserId();
				assignUserName = processAction.getAssignUserName();
				requestPayment = processAction.getRequestPayment();
				paymentFee = processAction.getPaymentFee();
				createDossierFiles = processAction.getCreateDossierFiles();
				returnDossierFiles = processAction.getReturnDossierFiles();
				eSignature = processAction.isESignature();
				signatureType = processAction.getSignatureType();
				createDossiers = processAction.getCreateDossiers();
				//
				actionService.updateProcessActionDB(userId, groupId, serviceProcessId, actionCode,
						actionName, preStepCode, postStepCode, autoEvent, preCondition, allowAssignUser,
						assignUserId, assignUserName, requestPayment, paymentFee, createDossierFiles, returnDossierFiles,
						eSignature, signatureType, createDossiers, serviceContext);
			}
		}
	}

	//LamTV_Process output ProcessRole to DB
	private static void processProcessRole(long userId, long groupId, long serviceProcessId, Roles processRoles,
			ServiceProcessActions actionService, ServiceContext serviceContext) {
		List<ProcessRole> processRoleList = processRoles.getProcessRole();
		if (processRoleList != null && processRoleList.size() > 0) {
			long roleId = 0;
			String roleName = StringPool.BLANK;
			boolean moderator = false;
			String condition = StringPool.BLANK;
			for (ProcessRole processRole : processRoleList) {
				roleId = processRole.getRoleId();
				roleName = processRole.getRoleName();
				moderator = processRole.isModerator();
				condition = processRole.getCondition();
				//
				actionService.updateServiceProcessRoleDB(20164l, 55301l, serviceProcessId, roleId, roleName,
						moderator, condition, serviceContext);
			}
		}
	}

	//LamTV_ Process output ProcessStep to DB
	private static void processProcessStep(long userId, long groupId, long serviceProcessId, Steps steps,
			ServiceProcessActions actionService, ServiceContext serviceContext) throws PortalException {
		List<ProcessStep> proStepList = steps.getProcessStep();
		if (proStepList != null && proStepList.size() > 0) {
			String stepCode = StringPool.BLANK;
			String stepName = StringPool.BLANK;
			Integer sequenceNo = 0;
			String groupName = StringPool.BLANK;
			String dossierStatus = StringPool.BLANK;
			String dossierSubStatus = StringPool.BLANK;
			Integer durationCount1 = 0;
			String instructionNote = StringPool.BLANK;
			String briefNote = StringPool.BLANK;
			String lockState = StringPool.BLANK;
			for (ProcessStep step : proStepList) {
				stepCode = step.getStepCode();
				stepName = step.getStepName();
				sequenceNo = step.getSequenceNo();
				groupName = step.getGroupName();
				dossierStatus = step.getDossierStatus();
				dossierSubStatus = step.getDossierSubStatus();
				durationCount1 = step.getDurationCount();
				instructionNote = step.getInstructionNote();
				briefNote = step.getBriefNote();
				lockState = step.getLockState();
				//
				long processStepId = actionService.updateProcessStepDB(userId, groupId, serviceProcessId, stepCode, stepName,
						sequenceNo, groupName, dossierStatus, dossierSubStatus, durationCount1,
						instructionNote, briefNote, lockState, serviceContext);
				//
				org.opencps.api.v21.model.Steps.ProcessStep.Roles stepRoles = step.getRoles();
				if (stepRoles != null) {
					processStepRole(userId, groupId, processStepId, stepRoles, actionService,
							serviceContext);
				}
			}
		}
	}

	//LamTV_ Process output ProcessStepRole to DB
	private static void processStepRole(long userId, long groupId, long processStepId,
			org.opencps.api.v21.model.Steps.ProcessStep.Roles stepRoles, ServiceProcessActions actionService,
			ServiceContext serviceContext) {
		List<StepRole> stepRoleList = stepRoles.getStepRole();
		if (stepRoleList != null && stepRoleList.size() > 0) {
			long roleId = 0;
			String roleName = StringPool.BLANK;
			boolean moderator = false;
			String condition = StringPool.BLANK;
			for (StepRole stepRole : stepRoleList) {
				roleId = stepRole.getRoleId();
				roleName = stepRole.getRoleName();
				moderator = stepRole.isModerator();
				condition = stepRole.getCondition();
				//
				actionService.updateProcessStepRoleDB(userId, groupId, processStepId, roleId, roleName,
						moderator, condition, serviceContext);
			}
		}
	}

	//LamTV_ Process DictItem
//	private static void processUpdateDictItem(long dictCollectionId, DictCollection dicts, DictcollectionInterface actionCollection) {
//		if (dictCollectionId > 0) {
//			Items itemList = dicts.getItems();
//			if (itemList != null) {
//				List<DictItem> dictItemList = itemList.getDictItem();
//				if (dictItemList != null && dictItemList.size() > 0) {
//					String itemCode = StringPool.BLANK;
//					String itemName = StringPool.BLANK;
//					String itemNameEN = StringPool.BLANK;
//					String itemDescription = StringPool.BLANK;
//					String parent = StringPool.BLANK;
//					Integer level = 0;
//					Integer sibling = 0;
//					String metadata = StringPool.BLANK;
//					for (DictItem dictItem : dictItemList) {
//						itemCode = dictItem.getItemCode();
//						itemName = dictItem.getItemName();
//						itemNameEN = dictItem.getItemNameEN();
//						itemDescription = dictItem.getItemDescription();
//						parent = dictItem.getParent();
//						level = dictItem.getLevel();
//						sibling = dictItem.getSibling();
//						metadata = dictItem.getMetadata();
//						//
////						long dictItemId = actionCollection.getDictItemByItemCode(dictCollectionId, parent, 55301l);
////						long dictItemId = actionCollection.updateDictItemDB(20164l, 55301l, dictCollectionId, itemCode, itemName, itemNameEN, itemDescription, parent,
////									level, sibling, metadata);
//					}
//				}
//			}
//		}
		
//	}

}