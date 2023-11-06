class SeatManager {
    // Min heap to store all unreserved seats.
    priority_queue<int, vector<int>, greater<int>> availableSeats;

public:
    SeatManager(int n) {
        // Initially all seats are unreserved.
        for (int seatNumber = 1; seatNumber <= n; ++seatNumber) {
            availableSeats.push(seatNumber);
        }
    }

    int reserve() {
        // Get the smallest-numbered unreserved seat from the min heap.
        int seatNumber = availableSeats.top();
        availableSeats.pop();
        return seatNumber;
    }

    void unreserve(int seatNumber) {
        // Push the unreserved seat in the min heap.
        availableSeats.push(seatNumber);
    }
};