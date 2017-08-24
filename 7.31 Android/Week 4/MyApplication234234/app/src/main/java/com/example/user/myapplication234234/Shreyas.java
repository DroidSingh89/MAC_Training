public class SmartDriverTermsAndConditionsFragmentPresenter extends LegalPresenter implements DocumentAcceptanceFragmentPresenter {

    private static final String SMART_DRIVER_SERVICE_TERMS_HTML_FILE_NAME = "Smart Driver Service Terms.html";
    private static final String SMART_DRIVER_SERVICE_TERMS_PDF_FILE_NAME = "Smart Driver Service Terms.pdf";

    public interface View extends LegalView {

        void showAppInProgressDialog();
        void showDeclineDialog(String title, String description);
        void showEnrollmentDialog(String title, String message, String buttonLabel);
        void dismissAppInProgressDialog();
        void navigateToDashBoard();
        void hideTermsAndConditionsAcceptanceButtons();
        void showBackButton();
    }

    private final VehicleDataUtils vehicleDataUtils;
    private final EmailLegalDocUtil emailLegalDocUtil;
    private final VehicleServiceHelper vehicleServiceHelper;
    private final SmartDriverUtil smartDriverUtil;
    private final Router router;
    private View view;

    @Inject
    public SmartDriverTermsAndConditionsFragmentPresenter(EventBus eventBus,
                                                          ResourceUtil resourceUtil,
                                                          VehicleDataUtils vehicleDataUtils,
                                                          EmailLegalDocUtil emailLegalDocUtil,
                                                          VehicleServiceHelper vehicleServiceHelper,
                                                          SmartDriverUtil smartDriverUtil,
                                                          Router router) {
        super(resourceUtil,eventBus);
        this.vehicleDataUtils = vehicleDataUtils;
        this.emailLegalDocUtil = emailLegalDocUtil;
        this.vehicleServiceHelper = vehicleServiceHelper;
        this.smartDriverUtil = smartDriverUtil;
        this.router = router;
    }

    public void setView(View view) {
        this.view = view;
        super.setView(view);
        configureButtons();
        registerEventBus();
    }

    private void configureButtons() {
        if(smartDriverUtil.isEnrolled()) {
            view.showBackButton();
            view.hideTermsAndConditionsAcceptanceButtons();
        }
    }

    public void onDetach() {
        unregisterEventBus();
    }

    public void onEventMainThread(VehicleTaskEvent event) {
        if(event != null && event.commandDetails != null) {
            VehicleCommand vehicleCommand = event.commandDetails.vehicleCommand;
            if (isCommandCompleted(vehicleCommand)) {
                view.dismissAppInProgressDialog();
                handleVehicleResponse(event);
            }
        }
    }

    private boolean isCommandCompleted(VehicleCommand vehicleCommand) {
        return vehicleCommand == VehicleCommand.dataServiceOptIn &&
                vehicleDataUtils.isCommandComplete(vehicleCommand);
    }

    private void handleVehicleResponse(VehicleTaskEvent event) {
        final boolean isEnrolled = event.didSucceed() && getEnrollmentStatus(event);
        if(isEnrolled) {
            showEnrollmentDialog();
        }
    }

    private void showEnrollmentDialog() {
        String dialogTitle = resourceUtil.getString(R.string.smart_driver_enrollment_pop_up_title, R.string.global_label_onstar);
        String dialogMessage = resourceUtil.getString(R.string.smart_driver_enrollment_pop_up_description);
        String dialogButton = resourceUtil.getString(R.string.global_dialog_ok);
        view.showEnrollmentDialog(dialogTitle, dialogMessage, dialogButton);
    }

    private boolean getEnrollmentStatus(VehicleTaskEvent event) {
        String enrollmentStatus = ((SetSmartDriverEnrollmentTaskEvent) event).getEnrollmentStatus();
        return enrollmentStatus != null ? Boolean.valueOf(enrollmentStatus) : false;
    }

    @Override
    public String getLegalHtmlFileName() {
        return SMART_DRIVER_SERVICE_TERMS_HTML_FILE_NAME;
    }

    @Override
    public void onAcceptButtonClicked() {
        view.showAppInProgressDialog();
        initiateSmartDriverEnrollmentRequest();
    }

    private void initiateSmartDriverEnrollmentRequest() {
        vehicleServiceHelper.initiateSetVehicleDataService(SMARTDRIVER_ENROLLMENT_SERVICE_CODE);
    }

    @Override
    public void onDeclineButtonClicked() {
        showConfirmDeclineDialog();
    }

    @Override
    public void onEmailButtonClicked(String content) {
        String assetFilePath = getLegalFilePath() + SMART_DRIVER_SERVICE_TERMS_PDF_FILE_NAME;
        emailLegalDocUtil.sendEmail(getEmailSubject(), assetFilePath, SMART_DRIVER_SERVICE_TERMS_PDF_FILE_NAME);
    }

    private String getEmailSubject() {
        String onStarSmartDriver = resourceUtil.getString(R.string.smart_driver_dashboard_title, R.string.global_label_onstar);
        String serviceTerms = resourceUtil.getString(R.string.smart_driver_enrollment_terms_subject_line_title);
        return resourceUtil.getString(R.string.legal_format_email_subject, onStarSmartDriver, serviceTerms);
    }

    @Override
    public void onConfirmDeclineClicked() {
        view.navigateToDashBoard();
    }

    @Override
    public void onBackPressed() {
        if(smartDriverUtil.isEnrolled()) {
            router.forceHide();
        } else {
            showConfirmDeclineDialog();
        }
    }

    private void showConfirmDeclineDialog() {
        String title = resourceUtil.getString(R.string.terms_label_decline);
        String formattedAppName = resourceUtil.getString(R.string.smart_driver_dashboard_title, R.string.global_label_onstar);
        String message = resourceUtil.getString(R.string.terms_label_decline_description, formattedAppName);
        view.showDeclineDialog(title, message);
    }
}

