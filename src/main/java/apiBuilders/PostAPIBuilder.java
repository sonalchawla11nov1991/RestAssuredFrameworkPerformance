package apiBuilders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostAPIBuilder {
    public Map<String, Object> configurePmsDesignRequestBody() {
        Map<String, Object> body = new HashMap<>();

        body.put("goal_setting_id", 695);
        body.put("org_id", 81);
        body.put("goal_cycle", "YEARLY");
        body.put("goal_cycle_name", "Apr2023-Mar2024");
        body.put("goal_framework", "OKR");
        body.put("custom_framework_by", "ROLE");
        body.put("goals_by", "ALL");
        body.put("department_name", null);
        body.put("role_name", null);
        body.put("goal_start_date", "2023-04-01T00:00:00.000Z");
        body.put("enable_goal_creation", "Y");
        body.put("goal_end_date", "2024-03-31T00:00:00.000Z");
        body.put("goal_creation_end_date", "OPEN");
        body.put("default_dates_with_cycle", "Y");
        body.put("edit_goal_date", "Y");
        body.put("goal_creator", "ALL_EMPLOYEE");
        body.put("goal_updator", "ALL");
        body.put("ms_creator", "GOAL_MS_OWNER");
        body.put("ms_updator", "GOAL_MS_OWNER");
        body.put("goal_approved_by", "MANAGER");
        body.put("goal_depth_planning", "OUTCOME_EFFORT");
        body.put("goal_rating_calculation", "CUSTOM");
        body.put("goal_progress_by", "Y");
        body.put("enable_comp_goal_linkage", "Y");
        body.put("enable_org_goal_linkage", "Y");
        body.put("enable_dept_goal_linkage", "N");
        body.put("enable_mgr_goal_linkage", "N");
        body.put("enable_goal_cycle_reminder", "N");
        body.put("auto_close_goal_by_days", "N");
        body.put("max_owned_goal", 100);
        body.put("goal_cycle_reminder_till_date", "");
        body.put("status", "OPEN");
        body.put("financial_year", "Apr2023-Mar2024");
        body.put("year_number", "2023");
        body.put("mail_subject", "Setting OKR for 2022- Q1");
        body.put("mail_body", "<div><^!--block-->Hello All,<br><br>As a company, we^’d like to start the process of getting clarity on what we^’ll achieve as individuals and as a team. This is required as it will help all of us to get aligned about what we should achieve(and what's not). And what concrete Key Result we^’ll use to measure success.<br><br>To kick off this process, we request you to meet your managers, so that you can think and discuss what you want to achieve to take our company ahead.<br><br>Last date to declare what you will achieve:&nbsp;<b> 2019-08-30</b><br><br>OKR Setting Link:&nbsp;<b> https://teampeoplestrong.qilo.co/^#/yourGoal </b><br><br><b>And here is a link to The Beginner's Guide to OKR-Setting.Explore this guide to understand why it's important to declare what you will achieve and how you can achieve it.<br><br><a target='_blank' href = 'https://teampeoplestrong.qilo.co/images/pdf/qilo_beginners_guide_to_okr.pdf'>https://teampeoplestrong.qilo.co/images/pdf/qilo_beginners_guide_to_okr.pdf</a><br><br>Thank you,<br>&lt;ORG_EMAIL_FROM&gt;</div>");
        body.put("reminder_mail_subject", "Reminder^! Objective and IDP pending for declaration at your end");
        body.put("reminder_mail_body", "<p><^!--block-->Hello ^@^@EMP_NAME,</p><p>You are getting this reminder because either of the following things are not done in our performance management system.</p><ul><li style='margin-bottom: 10px;'> You have not declared ^@^@MIN_GOALS Objective in the system.</li><li style='margin-bottom: 10px;'> You have not declared Individual development plan in the system.</li></ul> <p><b>How to declare the Objective and IDP in the system</b></p><ol><li style='margin-bottom: 10px;'> Go to performance module.</li><li style='margin-bottom: 10px;'> Click on the GOAL_MODULE_NAME menu.</li><li style='margin-bottom: 10px;'> On My Objective page, click on the ^“+ Objective button. It^’s there towards the right side of your screen.</li><li style='margin-bottom: 10px;'> To declare your IDP^’s, click on the ^“My IDP^” sub-menu under the GOAL_MODULE_NAME menu.</li></ol> <p>For any challenges, please reach out to your HR SPOC. Please ignore this email, if you have already done the needful.</p><p>Thank you,<br>Team HR</p>");
        body.put("is_active", 1);
        body.put("creation_dt", "2023-04-04T15:21:17.000Z");
        body.put("created_by", 738043);
        body.put("updation_dt", "2024-01-15T13:31:22.000Z");
        body.put("updated_by", 29164);
        body.put("disable_transparency_in_team_goal", "N");
        body.put("enable_capture_impact_area", "Y");
        body.put("enable_collaborative_goal", "Y");
        body.put("enable_effort", "Y");
        body.put("capture_effort_weightage", "Y");
        body.put("enable_check_in_frequency", "Y");
        body.put("capture_weight_on_goal", "Y");
        body.put("enable_auto_adjustment_goal_weightage", "N");
        body.put("capture_weight_on_milestone", "Y");
        body.put("performance_cycle_freq", "Yearly");
        body.put("min_owned_goal", 1);
        body.put("reminder_mail_days", "N");
        body.put("capture_weight_on_idp", "N");
        body.put("learning_program_source", "LMS");
        body.put("enable_input_course", 1);
        body.put("enable_checkIn", "Y");
        body.put("enableIDP", "Y");
        body.put("enable_move_to_draft", "Y");
        body.put("declare_idp_required", "Y");
        body.put("goal_milestone_updator_before_approval", "BOTH");
        body.put("capture_goal_weightage_value", "N");
        body.put("max_weightage_on_goal", 100);
        body.put("min_weightage_on_goal", 0);
        body.put("capture_measure_frequency", "Y");
        body.put("max_no_of_outcome", 10);
        body.put("capture_goal_rating_rules", "N");
        body.put("goal_rating_scale", 5);
        body.put("goal_rating_scale_new", 5);
        body.put("enable_auto_rating_by_progress", "N");
        body.put("auto_rating_rule_on", null);
        body.put("rating_range_override_by", null);
        body.put("goal_auto_approved_by_days", null);
        body.put("max_achievement_on_milestone", 150);
        body.put("enable_metric_measure", "Y");
        body.put("metric_measure_order", 1);
        body.put("enable_progress_measure", "Y");
        body.put("progress_measure_order", 2);
        body.put("enable_boolean_measure", "Y");
        body.put("boolean_measure_order", 3);
        body.put("rowkey", "2024-01-15T13:31:22.000Z");
        body.put("configure_annual_average_rating", "Y");
        body.put("show_annual_avg_final_rating_to_emp", "Y");
        body.put("show_annual_avg_final_rating_to_mgr", "N");
        body.put("show_avg_final_rating_logic", "N");
        body.put("reminder_mail_cc", new ArrayList<>());
        body.put("disable_target_editing", "N");
        body.put("reminder_mail_days_pip", "N");
        body.put("enable_manager_to_create_pip", "Y");
        body.put("who_can_edit_auto_rating", null);
        body.put("enableReviewAndClosure", 1);
        body.put("goal_creation_end_date_new", "OPEN");
        body.put("goal_frequency", "YEARLY");
        body.put("goal_cycle_status", "OPEN");

        List<Map<String, Object>> customGoalRating = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> rating = new HashMap<>();
            rating.put("rating_label", "");
            rating.put("score", "");
            customGoalRating.add(rating);
        }
        body.put("custome_goal_rating", customGoalRating);

        body.put("custom_framework_by_copy", "ROLE");
        body.put("goal_framework_copy", "OKR");
        body.put("enableCustomGoalSetting", false);
        body.put("enable_custom_goal_setting", "N");
        body.put("mandatoryCompGoalLink", true);
        body.put("include_reminder_days", "N");
        body.put("include_reminder_days_pip", "N");
        body.put("includeMetric", "Y");
        body.put("metricOrder", 1);
        body.put("includeProgress", "Y");
        body.put("progressOrder", 2);
        body.put("includeBoolean", "Y");
        body.put("emp_overide_rating_range", "N");
        body.put("mgr_overide_rating_range", "N");
        body.put("IncludeAllMeasure", true);
        body.put("booleanOrder", "3");
        return body;
    }

    public Map<String, Object> save9BoxDetailsRequestBody() {
        Map<String, Object> body = new HashMap<>();

        // Add general details
        body.put("type", "update");
        body.put("matrix_id", 11);
        body.put("x_axis_label", "Performance");
        body.put("x_axis_type", "Performance");
        body.put("y_axis_label", "Potential");
        body.put("y_axis_type", "Potential");
        body.put("x_value", 3);
        body.put("y_value", 3);
        body.put("org_id", 81);

        // Add matrix details
        Map<String, Object> matrixDetails = new HashMap<>();
        matrixDetails.put("matrix_col_id", 11);
        matrixDetails.put("mat_col1", "A4");
        matrixDetails.put("mat_col2", "B4");
        matrixDetails.put("mat_col3", "C4");
        matrixDetails.put("mat_col4", "D4");
        matrixDetails.put("mat_col5", "A3");
        matrixDetails.put("mat_col6", "B3");
        matrixDetails.put("mat_col7", "C3");
        matrixDetails.put("mat_col8", "D3");
        matrixDetails.put("mat_col9", "A2");
        matrixDetails.put("x3_axis_value", 5);
        matrixDetails.put("x2_axis_value", 3.33);
        matrixDetails.put("x1_axis_value", 1.67);
        matrixDetails.put("y3_axis_value", 5);
        matrixDetails.put("y2_axis_value", 3.33);
        matrixDetails.put("y1_axis_value", 1.67);
        matrixDetails.put("x1_label", "Does not Meet Expectation");
        matrixDetails.put("x2_label", "Meets Most Expectations");
        matrixDetails.put("x3_label", "Meets All Expectations");
        matrixDetails.put("y1_label", "Limited");
        matrixDetails.put("y2_label", "Fair");
        matrixDetails.put("y3_label", "High");

        body.put("matrixDetails", matrixDetails);

        return body;

    }

    public Map<String, Object> saveKpiLibGoalRequestBody() {
        Map<String, Object> body = new HashMap<>();

        // Add goal details
        Map<String, Object> goalDetails = new HashMap<>();
        goalDetails.put("linkType", "Department");
        goalDetails.put("goalName", "Objective 1");

        // Add goal nature details
        Map<String, Object> goalNature = new HashMap<>();
        goalNature.put("metadata_type_val_id", 38092);
        goalNature.put("org_id", 81);
        goalNature.put("metadata_id", 482);
        goalNature.put("metadata_value", "Individual OKR (Impact Individual)");
        goalNature.put("metadata_value_desc", "Individual OKR");
        goalNature.put("metadata_display_order", null);
        goalNature.put("currency", null);
        goalNature.put("is_active", "Y");
        goalNature.put("entity_id", 12);

        goalDetails.put("goalNature", goalNature);
        goalDetails.put("comp_goal_id", 8542795);
        goalDetails.put("linkTo", "Technology");
        goalDetails.put("linkToIds", "3838273");

        body.put("goalDetails", goalDetails);

        // Add KPI details
        List<Map<String, Object>> kpiDetails = List.of(
                Map.of(
                        "kpiName", "Key Result",
                        "progressType", "METRIC",
                        "EffortOrOutcome", "OUTCOME",
                        "startValue", 0,
                        "targetValue", 100,
                        "kpi_uom", "INR in lacs",
                        "type_of_outcome", "4x Pipeline Value(Specific to commercial)",
                        "targetCondition", "AT_LEAST"
                ),
                Map.of(
                        "kpiName", "Effort",
                        "progressType", "PERCENTAGE",
                        "EffortOrOutcome", "EFFORT",
                        "targetCondition", "AT_LEAST"
                )
        );

        body.put("kpiDetails", kpiDetails);

        // Add orgId and userId
        body.put("orgId", 81);
        body.put("userId", 29164);

        return body;


    }

    public Map<String, Object> createKpiLibraryExcelFormatRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("org_id", "U2FsdGVkX19rUr0nNzsjQ44IdLkdqoHFg3ncqRg8zjo=");
        body.put("entity_id", "U2FsdGVkX1/ZnIsLe6pIwd1zxY8G39wGrO9BuTyFEsg=");

        return body;
    }

    public Map<String, Object> saveBehaviourConfigRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("primary_parameter", "Behaviour");
        body.put("enable_secondary_behaviour", "N");

        return body;
    }

    public Map<String, Object> empWithoutGoalsV2RequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("capture_weight_on_goal", "Y");
        body.put("financialYear", "Apr2023-Mar2024");
        body.put("goal_setting_id", 695);
        body.put("lang", "en");
        body.put("min_owned_goal", 1);
        body.put("reportPeriod", "ALL");
        body.put("role_name", "SUPER_ADMIN");

        return body;
    }

    public Map<String, Object> empObjectiveProgressRequestBody() {
        Map<String, Object> body = new HashMap<>();

        // Add goal setting details
        body.put("goal_setting_id", 695);
        body.put("financial_year", "Apr2023-Mar2024");
        body.put("cycleFrequency", "ALL");
        body.put("goalReportType", "GOALMILEREPETCOL");
        body.put("typeFilterList", java.util.Collections.emptyList());
        body.put("statusFilterList", java.util.Collections.emptyList());
        body.put("milestoneFilterList", java.util.Collections.emptyList());
        body.put("org_id", 81);
        body.put("capture_weight_on_goal", "Y");
        body.put("selectedType", "GOALMILEREPETCOL");
        body.put("capture_goal_rating_scale", "N");
        body.put("capture_weightage_on_milestone", "Y");
        body.put("role_name", "SUPER_ADMIN");
        body.put("lang", "en");
        body.put("enable_capture_impact_area", "Y");

        return body;
    }

    public Map<String, Object> goalListRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("cycleValue", "ALL");
        body.put("financialYear", "Apr2023-Mar2024");
        body.put("goalSettingId", "QkfbZOStbj7p1L2u3SLYbGPs1L2a3S4ha8Zge1Q2u3A4le1Q2u3A4l");
        body.put("userId", null);
        body.put("from", null);


        return body;
    }

    public Map<String, Object> createGoalRequestBody() {
        Map<String, Object> body = new HashMap<>();

        // Add key-value pairs for the goal data
        body.put("startDate", "2023-04-01");
        body.put("dueDate", "2024-03-31");
        body.put("name", "Goal 1 for Automation");
        body.put("description", "");
        body.put("goalPeriod", "Q4");
        body.put("impactArea", "Individual OKR (Impact Individual)");
        body.put("goalAlignment", "c2kc5IwUfhs1L2a3S4h6OQAJeSwXbge1Q2u3A4le1Q2u3A4l");
        body.put("ownerId", "1g2Ls1L2a3S4hvBEJRZ61gp1L2u3SAna6hkge1Q2u3A4le1Q2u3A4l");
        body.put("goalType", "INDIVIDUAL");
        body.put("weightage", 100);
        body.put("goalAlignmentType", "COMPANY_GOAL");
        body.put("autoRatingList", null);

        // Add milestone list
        Map<String, Object> milestone = new HashMap<>();
        milestone.put("name", "Milestone");
        milestone.put("typeOfKR", "OUTCOME");
        milestone.put("progressType", "METRIC");
        milestone.put("startDate", "2023-10-01");
        milestone.put("dueDate", "2023-12-31");
        milestone.put("ownerId", "1g2Ls1L2a3S4hvBEJRZ61gp1L2u3SAna6hkge1Q2u3A4le1Q2u3A4l");
        milestone.put("uom", "INR in lacs");
        milestone.put("typeOfOutcome", "4x Pipeline Value(Specific to commercial)");
        milestone.put("weightage", 100);
        milestone.put("startValue", 0);
        milestone.put("targetValue", 100);
        milestone.put("targetCondition", "AT_LEAST");
        milestone.put("autoRatingList", null);

        body.put("milestoneList", List.of(milestone));
        body.put("goalRatingGuidelines", null);
        body.put("goalSettingId", "QkfbZOStbj7p1L2u3SLYbGPs1L2a3S4ha8Zge1Q2u3A4le1Q2u3A4l");

        return body;
    }

    public static Map<String, Object> goalSentForApprovalRequestBody() {
        Map<String, Object> body = new HashMap<>();

        // Add owner ID
        body.put("ownerId", "1g2Ls1L2a3S4hvBEJRZ61gp1L2u3SAna6hkge1Q2u3A4le1Q2u3A4l");

        // Add goal list
        List<Map<String, Object>> goalList = new ArrayList<>();

        goalList.add(Map.of("weightage", 25, "goalId", "sqLeTHp1L2u3S9vwcZ8xJ67ixJage1Q2u3A4le1Q2u3A4l"));
        goalList.add(Map.of("weightage", 25, "goalId", "ZsG3DI3VCQN3SFiGNEMagwe1Q2u3A4le1Q2u3A4l"));
        goalList.add(Map.of("weightage", 25, "goalId", "jjHTs1L2a3S4hkxJrifZTBv3LGwH5Qe1Q2u3A4le1Q2u3A4l"));
        goalList.add(Map.of("weightage", 25, "goalId", "uQ5qIm34BoWMyfIZazoYMQe1Q2u3A4le1Q2u3A4l"));

        body.put("goalList", goalList);

        // Add includeWeightage
        body.put("includeWeightage", true);

        return body;
    }

    public Map<String, Object> idpListRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("cycleValue", "ALL");
        body.put("financialYear", "Apr2023-Mar2024");
        body.put("goalSettingId", "QkfbZOStbj7p1L2u3SLYbGPs1L2a3S4ha8Zge1Q2u3A4le1Q2u3A4l");
        body.put("goal_nature", "IDP");

        return body;
    }

    public Map<String, Object> createIdpRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("startDate", "2023-04-01");
        body.put("dueDate", "2024-03-31");
        body.put("name", "IDP");
        body.put("description", "");
        body.put("impactArea", "IDP");
        body.put("ownerId", "1g2Ls1L2a3S4hvBEJRZ61gp1L2u3SAna6hkge1Q2u3A4le1Q2u3A4l");

        List<Map<String, Object>> milestoneList = new ArrayList<>();
        Map<String, Object> milestone = new HashMap<>();
        milestone.put("courseId", null);
        milestone.put("typeOfKR", "EFFORT");
        milestone.put("name", "Activity");
        milestone.put("startDate", "2023-04-01");
        milestone.put("dueDate", "2024-03-31");
        milestone.put("progressType", "BOOLEAN");

        List<String> taggedSkillNames = new ArrayList<>();
        taggedSkillNames.add("Component Ownership (*)");
        milestone.put("taggedSkillNames", taggedSkillNames);

        milestone.put("ownerId", "1g2Ls1L2a3S4hvBEJRZ61gp1L2u3SAna6hkge1Q2u3A4le1Q2u3A4l");

        milestoneList.add(milestone);
        body.put("milestoneList", milestoneList);
        return body;

    }


    public Map<String, Object> pipListRequestBody() {

        Map<String, Object> body = new HashMap<>();
        body.put("cycleValue", "ALL");
        body.put("financialYear", "Apr2023-Mar2024");
        body.put("goalSettingId", "QkfbZOStbj7p1L2u3SLYbGPs1L2a3S4ha8Zge1Q2u3A4le1Q2u3A4l");
        body.put("goal_nature", "PIP");
        return body;


    }

    public static Map<String, Object> launchReviewRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("appraisal_cycle_id", 3274);
        body.put("org_id", 81);
        body.put("email_to_confirm", "demo@peoplestrong.com");
        body.put("potential_weightage", 25);
        body.put("to_user_id", 29164);
        return body;
    }

    public static Map<String, Object> selfInitiateReviewRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("appraisalId", "Wdup1L2u3S3zUTWZrwuXaQu4dEUQe1Q2u3A4le1Q2u3A4l");
        body.put("reporteeId", "nmQseK7AgkwNo0QMGMp2owe1Q2u3A4le1Q2u3A4l");
        body.put("isFor", "SELF");
        return body;
    }


    public Map<String, Object> employeeReviewListRequestBody() {

        Map<String, Object> body = new HashMap<>();
        body.put("financialYear", "Apr2023-Mar2024");
        return body;


    }

    public Map<String, Object> l1ManagerReviewListRequestBody() {

        Map<String, Object> body = new HashMap<>();
        body.put("financialYear", "Apr2023-Mar2024");
        return body;


    }

    public Map<String, Object> l2ManagerReviewListRequestBody() {

        Map<String, Object> body = new HashMap<>();
        body.put("financialYear", "Apr2023-Mar2024");
        return body;


    }

    public Map<String, Object> createAppraisalRequestBody() {
        Map<String, Object> body = new HashMap<>();
        // Add appraisal settings details
        body.put("org_id", 81);
        body.put("appraisal_status", "DRAFT");
        body.put("appraisal_version", 2);
        body.put("overall_grading_scale", "CUSTOM");
        body.put("appraisal_custom_questions", java.util.Collections.emptyList());
        body.put("include_matrix_manager", "N");
        body.put("who_can_overwrite_overall_rating", "L1,L2");
        body.put("show_overall_rating", "L1_EMP,L2_EMP,FINAL_EMP");
        body.put("capture_learning_dev_needs", "N");
        body.put("capture_learning_assessment", "N");
        body.put("assessment_via_list", "N");
        body.put("selected_learning_assessment", java.util.Collections.emptyList());
        body.put("capture_promotion_recommendations", "N");
        body.put("show_manager_comments", "L1_EMP,L2_EMP");
        body.put("include_L2_review", "Y");
        body.put("skip_self_review", "N");
        body.put("show_goal_section_rating", "Y");
        body.put("goal_progress_by_outcome", "OUTCOME_EFFORT");
        body.put("show_idp_section_rating", "Y");
        body.put("show_skill_section_rating", "Y");
        body.put("show_potential_section_rating", "Y");
        body.put("descending_value", "N");
        body.put("enable_9Box", "N");
        body.put("enable_BellCurve", "N");
        body.put("validate_total_goal_weight", "Y");
        body.put("include_by_org_goal", "ALL");
        body.put("include_goal_by_milestone", "ALL");
        body.put("capture_pip", "N");
        body.put("weightage_on_idp", "Y");
        body.put("include_goal_in_review", "Y");
        body.put("include_idp_in_review", "Y");
        body.put("include_skill_in_review", "Y");
        body.put("include_360_potential_review", "Y");
        body.put("who_approve_final_rating", "NONE");
        body.put("goal_module_name", "Objective");
        body.put("skill_module_name", "Skills & Competencies");
        body.put("potential_module_name", "Organization Level Behaviors, Competencies, Values & Attributes");
        body.put("when_matrix_mgr_evaluate", "BEFORE_L1");
        body.put("is_manager_approve_peer", "N");
        body.put("is_manager_submit_before_multirater", "Y");
        body.put("is_manager_view_peer_fb", "N");
        body.put("is_peers_insight_viewable", "Y");
        List<Map<String, Object>> actorList = new ArrayList<>();
        Map<String, Object> actorDetails = new HashMap<>();
        actorDetails.put("label", "");
        actorDetails.put("dueDate", "");
        actorDetails.put("salary_hike_eligibility", false);
        actorDetails.put("incentive_eligibility", false);
        actorList.add(actorDetails);
        body.put("actorList", actorList);
        body.put("enable_actors_sequentially", 1);
        body.put("reminder_mail_subject", "");
        body.put("reminder_mail_content", "<p><^!--block-->Hello ^@^@EMP_NAME,</p> <p>This Email is to remind you to complete the following actions related to performance review.</p> <p>^#SELF Review Status: Pending Last date for self-review submission is: ^@^@SELF_REVIEW_END_DATE </p> <p>^#L1_MANAGER Review Status: Pending for 1 or more team member. Last date for manager to submit the review is: ^@^@MNGR_REVIEW_END_DATE </p> <p>^#L2_MANAGER Review/Normalization Status: Pending for 1 or more L2 team member. Last date for L2 to submit the review is: ^@^@L2_REVIEW_END_DATE </p> <p>Thank you for your support. And we look forward to completing the above-listed actions immediately.</p> <p>^#NORMALIZATION Please normalize rating before due date. </p> <p>^#TABLE</p> <p>Thank you,<br> Team HR </p>");
        body.put("who_can_edit_auto_rating", "NONE");
        body.put("allow_submission_for_next_reviewer", "N");
        body.put("showCommentSuggestion", false);
        body.put("enable_comment_suggestion", "N");
        body.put("notification_on_submission", "L1_EMP,L2_EMP");
        body.put("display_during_review", "L1_EMP,L2_EMP");
        body.put("review_pay_integration", null);
        body.put("commentSuggList", java.util.Collections.emptyList());
        body.put("auto_assign_courses", "N");
        body.put("enable_last_actor_final_rating", "Y");
        body.put("launch_mail_content", "<div><^!--block-->Hi ^@^@EMP_NAME,<br><br>I hope you and your family are keeping safe and healthy.<br><br>&nbsp;We at <strong><em>write_org_name </em></strong><strong>&nbsp;</strong> have collectively weathered a challenging year, I thank you for your dedication and contribution to <strong><em>write_org_name</em></strong>. Acknowledging your efforts, we have launched the <strong><em>write_appraisal_cycle_name</em></strong>, effective ^@^@SELF_REVIEW_START_DATE, itself.<br><br>Please fill the self-review by ^@^@SELF_REVIEW_END_DATE<br>Fill up your team member^’s review by ^@^@MNGR_REVIEW_END_DATE.<br>Fill up your L2 team member^’s review by ^@^@L2_REVIEW_END_DATE. <br><br>Looking forward to your active participation.<br><br>Regards,<br>HR&nbsp;</div>");
        body.put("orgGoalListModel", java.util.Collections.emptyList());
        body.put("appraisal_cycle_name", "First Automation Review");
        body.put("financial_year", "Apr2023-Mar2024");
        body.put("applicable_for_doj", "Y");
        body.put("doj_for_applicable_employees", "2024-01-24");
        body.put("applicable_for_custom_band_or_role", "");
        body.put("applicable_for_custom_band_or_role_copy", "");
        List<Map<String, String>> customBandRoleDetails = List.of(
                Map.of("department", "", "band", "", "role", "")
        );
        body.put("show_self_rating_to_user", "Y");
        body.put("show_l1_rating_to_user", "Y");
        body.put("show_l2_rating_to_user", "Y");
        body.put("l2_reviewer_type", "L2_ACT_AS_REVIEWER");
        body.put("self_review_start_date", "2024-01-24");
        body.put("self_review_end_date", "2024-01-26");
        body.put("manager_review_end_date", "2024-01-28");
        body.put("normalization_end_dt", "2024-01-30");
        body.put("make_checkin_mandatory", "");
        // Adding custom grading scale
        List<Map<String, Object>> customGradingScale = new ArrayList<>();
        customGradingScale.add(createRatingScale(0, 1, "C", "Non Performer"));
        customGradingScale.add(createRatingScale(1.01, 2, "B", "Under Performer"));
        customGradingScale.add(createRatingScale(2.01, 3, "B+", "Average Performer"));
        customGradingScale.add(createRatingScale(3.01, 4, "A", "Good Performer"));
        customGradingScale.add(createRatingScale(4.01, 5, "A+", "Best Performer"));

        body.put("custom_grading_scale", customGradingScale);

        // Adding custom skill rating scale
        List<Map<String, Object>> customSkillRatingScale = new ArrayList<>();
        customSkillRatingScale.add(createSkillRating(2, "Elementary Proficiency", "You are now regularly applying the fundamental concepts & principle regularly at work"));
        customSkillRatingScale.add(createSkillRating(3, "Professional Working Proficiency", "You are now becoming expert on the concepts and principles. And can do this well without any help"));
        customSkillRatingScale.add(createSkillRating(4, "Full Professional Proficiency", "You have done this in multiple companies, industries, and business cases and can design and lead a project"));
        customSkillRatingScale.add(createSkillRating(5, "Industry Expert", "You are a global expert at this and could ^“write the book^” or ^“teach a class^” on this"));

        body.put("custom_skill_rating_scale", customSkillRatingScale);

        // Adding potential data
        List<Map<String, Object>> potentialData = new ArrayList<>();
        Map<String, Object> behaviorData = new HashMap<>();
        behaviorData.put("appraisal_title", "Behaviour");
        behaviorData.put("max_no_of_appraisal_que_pages", 1);
        potentialData.add(behaviorData);

        body.put("potential_data", potentialData);
        body.put("enable_rating_on_secondary_behaviour", "N");

        // Adding custom potential rating scale
        List<Map<String, Object>> customPotentialRatingScale = new ArrayList<>();
        customPotentialRatingScale.add(createPotentialRating(null, 1, "Never", "Never"));
        customPotentialRatingScale.add(createPotentialRating(null, 2, "Sometimes", "Sometimes"));
        customPotentialRatingScale.add(createPotentialRating(null, 3, "Frequently", "Frequently"));
        customPotentialRatingScale.add(createPotentialRating(null, 4, "Always", "Always"));
        customPotentialRatingScale.add(createPotentialRating(null, 5, "Outstanding", "Outstanding"));

        body.put("custom_potential_rating_scale", customPotentialRatingScale);

        body.put("goals_review_weightage", 25);
        body.put("allow_rating_on_goal", "EMP,L1,L2");
        body.put("comments_require_goal", "");
        body.put("idp_review_weightage", 25);
        body.put("allow_rating_on_idp", "EMP,L1,L2");
        body.put("comments_require_idp", "");
        body.put("skill_review_weightage", 25);
        body.put("allow_rating_on_skill", "EMP,L1,L2");
        body.put("comments_require_skill", "");
        body.put("360_potential_review_weightage", 25);
        body.put("allow_rating_on_potential", "EMP,L1,L2");
        body.put("comments_require_potential", "");
        body.put("goals_to_be_considered_for_review", "YR");
        body.put("enable_multi_rater_on_goal", "N");
        body.put("who_can_nominate_peer", "");
        body.put("multi_rater_goal_fb_type", null);
        body.put("enable_multi_rater_on_skill", "N");
        body.put("enable_multi_rater_on_potential", "N");
        body.put("goal_rating_scale", "CUSTOM");
        List<Map<String, Object>> customGoalRatingScale = new ArrayList<>();
        customGoalRatingScale.add(createGoalRating(1, "Poor", "Poor"));
        customGoalRatingScale.add(createGoalRating(2, "Average", "Average"));
        customGoalRatingScale.add(createGoalRating(3, "Good", "Good"));
        customGoalRatingScale.add(createGoalRating(4, "Excellent", "Excellent"));
        customGoalRatingScale.add(createGoalRating(5, "Outstanding", "Outstanding"));
        body.put("custom_goal_rating_scale", customGoalRatingScale);

        // IDP Rating Scale
        body.put("idp_rating_scale", "CUSTOM");

        // Custom IDP Rating Scale
        List<Map<String, Object>> customIdpRatingScale = new ArrayList<>();
        customIdpRatingScale.add(createIdpRating(1, "Poor", "Poor"));
        customIdpRatingScale.add(createIdpRating(2, "Average", "Average"));
        customIdpRatingScale.add(createIdpRating(3, "Good", "Good"));
        customIdpRatingScale.add(createIdpRating(4, "Excellent", "Excellent"));
        customIdpRatingScale.add(createIdpRating(5, "Outstanding", "Outstanding"));
        body.put("custom_idp_rating_scale", customIdpRatingScale);

        // Grading Range Type
        body.put("grading_range_type", "NUMERIC");

        // Display Rating Value
        body.put("display_rating_value", "N");

        // Custom Grading Scale Copy
        List<Map<String, Object>> customGradingScaleCopy = new ArrayList<>();
        customGradingScaleCopy.add(createGradingScale(0, 1, "C", "Non Performer"));
        customGradingScaleCopy.add(createGradingScale(1.01, 2, "B", "Under Performer"));
        customGradingScaleCopy.add(createGradingScale(2.01, 3, "B+", "Average Performer"));
        customGradingScaleCopy.add(createGradingScale(3.01, 4, "A", "Good Performer"));
        customGradingScaleCopy.add(createGradingScale(4.01, 5, "A+", "Best Performer"));
        body.put("custom_grading_scale_copy", customGradingScaleCopy);

        body.put("promotion_recommendations_by", null);
        body.put("edit_goal_weightage", "N");
        body.put("is_send_launch_mail", "N");
        return body;
    }

    private static Map<String, Object> createRatingScale(double from, double to, String label, String description) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("rating_scale_from", from);
        entry.put("rating_scale_to", to);
        entry.put("rating_label", label);
        entry.put("rating_label_description", description);
        return entry;
    }

    private Map<String, Object> createSkillRating(int rating, String label, String description) {
        Map<String, Object> skillRatingScale = new HashMap<>();
        skillRatingScale.put("rating", rating);
        skillRatingScale.put("rating_label", label);
        skillRatingScale.put("rating_description", description);

        // Similar structure for custom skill rating scale...

        return skillRatingScale;
    }

    private Map<String, Object> createPotentialRating(Integer appraisalCycleId, int rating, String label, String description) {
        Map<String, Object> potentialRatingScale = new HashMap<>();
        potentialRatingScale.put("appraisal_cycle_id", appraisalCycleId);
        potentialRatingScale.put("rating", rating);
        potentialRatingScale.put("rating_label", label);
        potentialRatingScale.put("rating_description", description);
        return potentialRatingScale;

    }


    private static Map<String, Object> createGoalRating(int rating, String label, String description) {
        Map<String, Object> ratingMap = new HashMap<>();
        ratingMap.put("rating", rating);
        ratingMap.put("rating_label", label);
        ratingMap.put("rating_description", description);
        return ratingMap;
    }

    private static Map<String, Object> createIdpRating(int rating, String label, String description) {
        Map<String, Object> ratingMap = new HashMap<>();
        ratingMap.put("rating", rating);
        ratingMap.put("rating_label", label);
        ratingMap.put("rating_description", description);
        return ratingMap;
    }

    private static Map<String, Object> createGradingScale(double from, double to, String label, String description) {
        Map<String, Object> gradingScaleMap = new HashMap<>();
        gradingScaleMap.put("rating_scale_from", from);
        gradingScaleMap.put("rating_scale_to", to);
        gradingScaleMap.put("rating_label", label);
        gradingScaleMap.put("rating_label_description", description);
        return gradingScaleMap;
    }

    public static Map<String, Object> lastCheckInRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("org_id", 81);
        body.put("role_name", "SUPER_ADMIN");
        return body;
    }

    public static Map<String, Object> dailyCheckInRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("org_id", 81);
        body.put("role_name", "SUPER_ADMIN");
        body.put("data_till", "TODAY");
        return body;

    }

    public static Map<String, Object> participationReportRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("org_id", 81);
        body.put("appraisal_cycle_id", 2806);
        body.put("l2_reviewer_type", null);
        body.put("appraisal_status", "CLOSED");
        body.put("appraisal_type", null);
        body.put("role_name", "SUPER_ADMIN");
        return body;
    }

    public static Map<String, Object> appraisalCycleRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("org_id", 81);
        body.put("appraisal_type", "PERIODIC_REVIEW");
        body.put("role_name", "SUPER_ADMIN");
        return body;

    }
    public static Map<String, Object> detailedReportRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("org_id", 81);
        body.put("appraisal_cycle_id", 2203);
        body.put("appraisal_cycle_name", "YEE Performance Review Non-Tech 2022-23");
        body.put("selectedType", "GOAL");
        body.put("selectedTypeName", "OKR");
        body.put("skip_self_review", "N");
        body.put("skip_self_review_goal", null);
        body.put("skip_self_review_potential", null);
        body.put("skip_self_review_skill", "N");
        body.put("include_l2_review", "N");
        body.put("capture_weightage_on_goal", "Y");
        body.put("capture_weightage_on_idp", "N");
        body.put("capture_goal_rating_rules", "N");
        body.put("appraisal_status", "CLOSED");
        body.put("l2ReviewerType", null);
        body.put("enable_multi_rater_on_goal", null);
        body.put("enable_multi_rater_on_potential", "Y");
        body.put("enable_multi_rater_on_skill", "N");
        body.put("goal_rating_scale", "CUSTOM");
        body.put("idp_rating_scale", "");
        body.put("potential_rating_scale", "CUSTOM");
        body.put("skill_rating_scale", "");
        body.put("role_name", "SUPER_ADMIN");
        body.put("lang", "en");
        body.put("dataLength", 1625);
        body.put("enableMultiEntity", 0);
        return body;


    }

    public static Map<String, Object> detailedDownloadReportRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("appraisal_cycle_id", 81);
        body.put("org_id", 81);
        body.put("role_name","SUPER_ADMIN");

        return body;


    }

    public static Map<String, Object> getRatingFullDataRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("appraisal_cycle_id", 2806);
        body.put("appraisal_status", "CLOSED");
        body.put("appraisal_type",null);
        body.put("l2_reviewer_type",null);
        body.put("org_id",81);
        body.put("role_name","SUPER_ADMIN");


        return body;


    }

    public static Map<String, Object> getCFRDataRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("end_date", "2024-03-31");
        body.put("lang", "en");
        body.put("role_name","SUPER_ADMIN");
        body.put("start_date","2023-03-01");
        return body;


    }

    public static Map<String, Object> getAuditLogRequestBody() {
        Map<String, Object> body = new HashMap<>();

        // Create selectedEmployees list
        List<Map<String, Object>> selectedEmployeesList = new ArrayList<>();
        Map<String, Object> selectedEmployee = new HashMap<>();
        selectedEmployee.put("user_id", 822143);
        selectedEmployee.put("full_name", "Sonal Chawla");
        selectedEmployee.put("email", "demo@peoplestrong.com");
        selectedEmployeesList.add(selectedEmployee);

        // Add data to the main body
        body.put("selectedEmployees", selectedEmployeesList);
        body.put("goal_setting_id", 695);
        body.put("lang", "en");

        return body;
    }


    public static Map<String, Object> getAuditLogDownloadRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("excelType", "goal_audit_report");
        body.put("timeStamp", 1707951315230L);

        return body;
    }


    public static Map<String, Object> getConsolidatedRatingReportRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("logInfo_id", 724);
        body.put("org_id", 81);
        body.put("report_type","CONSOLIDATED_RATING_REPORT");

        return body;
    }


    public static Map<String, Object> getApproveGoalRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("action", "ACCEPT");
        body.put("comments", null);

        List<Map<String, Object>> goalList = new ArrayList<>();
        Map<String, Object> goal = new HashMap<>();
        goal.put("weightage", 25);
        goal.put("goalId", "0OciBJxjCqYTKy5ZdUeRaQe1Q2u3A4le1Q2u3A4l");
        goalList.add(goal);

        body.put("goalList", goalList);

        return body;
    }

    public static Map<String, Object> getRejectGoalRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("action", "REJECT");
        body.put("comments", "Rejected");

        List<Map<String, Object>> goalList = new ArrayList<>();
        Map<String, Object> goal = new HashMap<>();
        goal.put("weightage", 25);
        goal.put("goalId", "s1L2a3S4hUVnsteaSXamCrTJs1L2a3S4hnMbs1L2a3S4hge1Q2u3A4le1Q2u3A4l");
        goalList.add(goal);

        body.put("goalList", goalList);

        return body;


    }

    public static Map<String, Object> getSendForGoalReviewandClosureRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("goalId", "yebeNPhe5hbHKFi7iPkndAe1Q2u3A4le1Q2u3A4l");
        return body;
    }
    public static Map<String, Object> getSendForGoalClosureRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("goalId", "0OciBJxjCqYTKy5ZdUeRaQe1Q2u3A4le1Q2u3A4l");
        return body;
    }

    public static Map<String, Object> getSendForGoalClosureRejectRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("rejectComments","Rejected");
        body.put("goalId", "4IfrV5HjI1s1L2a3S4hSZEYFVNXGMwe1Q2u3A4le1Q2u3A4l");

        return body;
    }


    public static Map<String, Object> idpSendForApprovalRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("ownerId", "nmQseK7AgkwNo0QMGMp2owe1Q2u3A4le1Q2u3A4l");
        body.put("includeWeightage", true);

        List<Map<String, Object>> goalList = new ArrayList<>();
        Map<String, Object> goal = new HashMap<>();
        goal.put("weightage", 0);
        goal.put("goalId", "PMdt0cPpSWEDz72wKpwp1L2u3Smwe1Q2u3A4le1Q2u3A4l");
        goalList.add(goal);

        body.put("goalList", goalList);

        return body;
    }

    public static Map<String, Object> getIDPRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("action", "ACCEPT");
        body.put("comments", null);

        List<Map<String, Object>> goalList = new ArrayList<>();
        Map<String, Object> goal = new HashMap<>();
        goal.put("weightage", 0);
        goal.put("goalId", "PMdt0cPpSWEDz72wKpwp1L2u3Smwe1Q2u3A4le1Q2u3A4l");
        goalList.add(goal);

        body.put("goalList", goalList);

        return body;
    }

    public static Map<String, Object> getRejectIDPRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("action", "ACCEPT");
        body.put("comments", null);

        List<Map<String, Object>> goalList = new ArrayList<>();
        Map<String, Object> goal = new HashMap<>();
        goal.put("weightage", 0);
        goal.put("goalId", "PMdt0cPpSWEDz72wKpwp1L2u3Smwe1Q2u3A4le1Q2u3A4l");
        goalList.add(goal);

        body.put("goalList", goalList);

        return body;
    }


    public static Map<String, Object> getEmployeeSubmitReviewRequestBody() {
        Map<String, Object> body = new HashMap<>();
       body.put( "appraisalId","xrjdVcqoSus1L2a3S4hvAHhqvSVoZge1Q2u3A4le1Q2u3A4l");
       body.put("reporteeId", "nmQseK7AgkwNo0QMGMp2owe1Q2u3A4le1Q2u3A4l");
       body.put("isFor", "SELF");

        return body;
    }
    public static Map<String, Object> getEmployeeSubmitReviewPDFRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put( "appraisalId","xrjdVcqoSus1L2a3S4hvAHhqvSVoZge1Q2u3A4le1Q2u3A4l");
        body.put("reporteeId", "nmQseK7AgkwNo0QMGMp2owe1Q2u3A4le1Q2u3A4l");
        body.put("shownTo", "SELF");

        return body;
    }

    public static Map<String, Object> getL1SubmitReviewRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put( "appraisalId","xrjdVcqoSus1L2a3S4hvAHhqvSVoZge1Q2u3A4le1Q2u3A4l");
        body.put("reporteeId", "nmQseK7AgkwNo0QMGMp2owe1Q2u3A4le1Q2u3A4l");
        body.put("isFor", "MGR");

        return body;
    }
    public static Map<String, Object> getL1SubmitReviewPDFRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put( "appraisalId","xrjdVcqoSus1L2a3S4hvAHhqvSVoZge1Q2u3A4le1Q2u3A4l");
        body.put("reporteeId", "nmQseK7AgkwNo0QMGMp2owe1Q2u3A4le1Q2u3A4l");
        body.put("shownTo", "MGR");

        return body;
    }


    public static Map<String, Object> getL2SubmitReviewRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put( "appraisalId","xrjdVcqoSus1L2a3S4hvAHhqvSVoZge1Q2u3A4le1Q2u3A4l");
        body.put("reporteeId", "nmQseK7AgkwNo0QMGMp2owe1Q2u3A4le1Q2u3A4l");
        body.put("isFor", "L2MGR");

        return body;
    }
    public static Map<String, Object> getL2SubmitReviewPDFRequestBody() {
        Map<String, Object> body = new HashMap<>();
        body.put( "appraisalId","xrjdVcqoSus1L2a3S4hvAHhqvSVoZge1Q2u3A4le1Q2u3A4l");
        body.put("reporteeId", "nmQseK7AgkwNo0QMGMp2owe1Q2u3A4le1Q2u3A4l");
        body.put("shownTo", "L2MGR");

        return body;
    }



}