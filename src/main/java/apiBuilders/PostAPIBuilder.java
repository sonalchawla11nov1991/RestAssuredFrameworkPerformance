package apiBuilders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostAPIBuilder {

    public  Map<String, Object> createGoalRequestBody() {
        Map<String, Object> body = new HashMap<>();

        // Add key-value pairs for the goal data
        body.put("startDate", "2024-10-01");
        body.put("dueDate", "2024-12-31");
        body.put("name", "Goal 1 for Automation");
        body.put("description", "");
        body.put("goalPeriod", "Q4");
        body.put("impactArea", "Individual OKR (Impact Individual)");
        body.put("goalAlignment", "rgG7L2Uvj9JNqAPiixUCWAe1Q2u3A4le1Q2u3A4l");
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

}
