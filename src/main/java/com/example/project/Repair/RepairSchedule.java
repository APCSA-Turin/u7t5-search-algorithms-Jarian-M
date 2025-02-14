package com.example.project.Repair;
import java.util.ArrayList;

import com.example.project.Linear_Search.Search;

public class RepairSchedule {
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n) {
        /* to be implemented in part (a) */
        numberOfMechanics = n;
        schedule = new ArrayList<>();
    }

    public ArrayList<CarRepair> getSchedule() {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b) {
        boolean check1 = false;
        boolean check2 = false;
        if(schedule.size() == 0) {
            schedule.add(new CarRepair(m,b));
            return true;
        }
        for(int i = 0; i < schedule.size(); i++) {
            if(schedule.get(i).getMechanicNum() == m) {
                check1 = true;
            }
            if(schedule.get(i).getBayNum() == b) {
                check2 = true;
            }
        }
        if(!check1) {
            if(!check2) {
                schedule.add(new CarRepair(m,b));

                return true;
            }
        }
        return false;
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics() {
        ArrayList<Integer> mechanics = new ArrayList<Integer>();
        for(int i = 0; i < numberOfMechanics; i++) {
            mechanics.add(i);
        }
        if(schedule.size() == 0) {
            return mechanics;
        }
        for(int j = 0; j < schedule.size(); j++) {
            for(int k = 0; k < mechanics.size(); k++) {
                if(schedule.get(j).getMechanicNum() == mechanics.get(k)) {
                    mechanics.remove(k);
                }
            }
        }
        return mechanics;
    }

    /** Removes an element from schedule when a repair is complete.
        THIS METHOD HAS BEEN ADDED FOR ILLUSTRATIVE PURPOSES ONLY,
        AS DESCRIBED IN PART B; you do NOT need to call this
        method as part of your solution to part B
      */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}
