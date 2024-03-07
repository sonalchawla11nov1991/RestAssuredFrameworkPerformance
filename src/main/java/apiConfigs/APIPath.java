package apiConfigs;

public class APIPath {
    public static final class apiPath {
        //delete user
        public static final String CONFIGURE_PMS_DESIGN="goal/api/v1/leadership/configurePMSDesign";

        public static final String EMP_WITHOUT_GOALS="goal/api/v1/leadership/empWithoutGoalsV2";
        public static final String OVERALL_OBJECTIVE_PROGRESS="goal/api/v1/employee/createExcelForGoalDownload";

        public static final String SAVE_BEHAVIOUR_CONFIG="goal/api/v1/leadership/savebehaviourConfig";
        public static  final String SAVE_9BOX_DETAILS="emp/api/v1/leadership/save9BoxDetails";
        public static final String SAVE_KPI_LIB_GOAL="goal/api/v1/leadership/saveKpiLibGoal";
        public static  final String KPI_LIB_Excel_FORMAT="goal/api/v1/leadership/createKpiLibraryExcelFormat";
        public static final String GOAL_LIST="service/oneweb/api/goal/employee/myGoalList";
        public static final String CREATE_GOAL="service/oneweb/api/goal/employee/createGoal";
        public static final String GOAL_SENT_FOR_APPROVAL="service/oneweb/api/goal/employee/create-bulk-goal";
        public static final String IDP_LIST="service/oneweb/api/goal/employee/myIDPList";
        public static final String CREATE_IDP="service/oneweb/api/goal/employee/createIDP";
        public static final String PIP_LIST="service/oneweb/api/goal/employee/myPIPList";
        public static  final String EMPLOYEE_REVIEW_LIST="service/oneweb/api/appraisal/employee/myReviewList";
        public static final String L1_MANAGER_REVIEW_LIST="service/oneweb/api/appraisal/leadership/L1/teamReviewList";
        public static final String L2_MANAGER_REVIEW_LIST="service/oneweb/api/appraisal/leadership/L2/teamReviewList";


        //public static final String PERFORMANCE_DESIGN_SAVE="goal/api/v1/leadership/configurePMSDesign"

        public static final String CREATE_APPRAISAL="goal/api/v2/leadership/create-appraisal";
        public static final String LAUNCH_REVIEW="goal/api/v2/leadership/launch-appr-cycle-new";
        public static final String SELF_INITIATE_REVIEW="service/oneweb/api/goal/employee/getPerfReviewDetails";

        public static final String LAST_CHECK_IN="goal/api/v1/leadership/userCheckinReport";

        public  static final String DAILY_CHECK_IN="goal/api/v1/leadership/dailyCheckinData";

        public  static final String PARTICIPATION_REPORT="goal/api/v2/leadership/participation-report";

        public  static final String APPRAISAL_CYCLE_LIST="goal/api/v1/leadership/getAllAppraisalCycles";
        public static final String DETAILED_RATING_REPORT="goal/api/v2/leadership/create-detailed-report-excel2";
  //      public static final String
        public static final String DETAILED_DOWNLOAD_REPORT="goal/api/v2/leadership/getDownloadedReport";

        public static final String FINAL_RATING_REPORT="goal/api/v1/leadership/get-rating-full-data";

        public static final String CFR_REPORT="goal/api/v2/leadership/cfr-report";

        public static final String AUDIT_LOG_REPORT="goal/api/v1/leadership/goal-audit-report";

        public static final String AUDIT_LOG_REPORT_DOWNLOAD="goal/api/v1/leadership/downloadGoalsExcelFromDashboard";

        public static final String CONSOLIDATED_RATING_REPORT="goal/api/v2/leadership/downloadReportFromS3";

        public static final String APPROVE_GOAL="service/oneweb/api/goal/leadership/approveRejectGoals";

        public static final String REVIEW_AND_CLOSURE="service/oneweb/api/goal/employee/initiateGoalClosing";

        public static final String GOAL_CLOSURE="service/oneweb/api/goal/leadership/goalCloseByManager";

        public static final String GOAL_REJECT_CLOSURE="service/oneweb/api/goal/leadership/goalCloseRejectByManager";

        public static final String IDP_APPROVAL="service/oneweb/api/goal/employee/create-bulk-idp";

        public static final String SUBMIT_REVIEW="/service/oneweb/api/goal/employee/submitReview";

        public static final String EMPLOYEE_PDF="/service/oneweb/api/goal/employee/pdfSummaryByUserId";




    }


    public static void main(String[] args) {
//        System.out.println(APIPath.apiPath.CREATE_USER);
//        System.out.println(apiPath.GET_LIST_OF_USERS);
    }
}
