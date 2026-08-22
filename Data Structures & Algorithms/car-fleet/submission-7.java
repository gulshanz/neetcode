class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] cars = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> (b[0]-a[0]));


        double lastTime = -1;
        int fleets = 0;
        
        for(int i=0;i<position.length;i++){
            int currPosition = cars[i][0];
            int currSpeed = cars[i][1];
            double currTime = (double)(target-currPosition)/currSpeed;
            if(fleets==0||currTime>lastTime){
                fleets++;
                lastTime = currTime;
            }
        }

        return fleets;
    }
}
