package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelectionDemo {

    public static void main(String aa[]) {
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(3, 7));
        activityList.add(new Activity(6, 18));
        activityList.add(new Activity(8, 12));
        activityList.add(new Activity(2, 4));
        activityList.add(new Activity(1, 17));
        activityList.add(new Activity(19, 21));
        // Collections.sort(activityList,new ActivitySort());
        //activityList.stream().forEach(x-> System.out.println(" value "+ x.toString()));

        System.out.println("Total Parked Activity :" + countActivity(activityList));

    }

    public static int countActivity(List<Activity> activityList) {

        // sort activity by their finish time, Next activity will be slelect based on finish time
        // if activity finish at x time then another activity will be start after x+1
        Collections.sort(activityList, new ActivitySort());
        int c = 0;
        int finish_index = 0;
        int count = 1;
        Activity activities[] = activityList.toArray(new Activity[activityList.size()]);
        for (int i = 1; i < activityList.size(); i++) {
            if (activities[finish_index].getEnd() < activities[i].getStart()) {
                System.out.println(activities[finish_index].getStart() + " and " + activities[finish_index].getEnd());
                count++;
                finish_index = i;
            }
        }
        System.out.println(activities[finish_index].getStart() + " and " + activities[finish_index].getEnd());
        return count;
    }
}
