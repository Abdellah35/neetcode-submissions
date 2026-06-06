class MyCalendar {
    List<int[]> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] event: events) {
            if (event[1] > startTime && endTime > event[0]) {
                return false;
            }
        }

        events.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */