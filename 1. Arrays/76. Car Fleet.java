// https://leetcode.com/problems/car-fleet/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {

     class Car {
        int pos;
        int speed;
        
        public Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        
        for(int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        
        //Sort the car positions in descending order
        Arrays.sort(cars, (a, b) -> b.pos - a.pos);
        
        Stack<Double> st = new Stack<>();

        for(Car car : cars) {
            //Calculate the time it takes for each car to reach target
            double time = (double)(target - car.pos) / car.speed;
            //If the time taken to reach target is less than the car in front then it means they merged along the way hence 
            //we  don't add to the stack.
            if(st.isEmpty() || st.peek() < time) {
                st.push(time);
            }
        }

        return st.size();
    }
}