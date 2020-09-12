package Meeting;

public class MeetingRoom3 {
    // some rough idea:
    // Mapping: MeetingRoom - Capcity, using for Heap1
    // Mapping: start time - meeting
    // Mapping: start time - numPeople
    // Mapping: start time - endtime
    // Mapping: UsedMeetingRoom - end time, using for Heap2
    // Heap1: all the meeting room, sort base on the capacity
    // Heap2: all the Used meeting room, sort base on the endTime
    // sort the start time
    // sort the end time
    // two pointers: start, end;
    //
    // loop the start: 0 - N:
    // if (start >= end):
    // pop the room in heap2 back
    // end++;
    //
    // loop the Heap1 to find one whose capacity is enough
    // if no such MeetingRoom: return impossible
    // else: pop the room, add to heap2, mapping put(room, end time of this start
    // time), add to result
}
