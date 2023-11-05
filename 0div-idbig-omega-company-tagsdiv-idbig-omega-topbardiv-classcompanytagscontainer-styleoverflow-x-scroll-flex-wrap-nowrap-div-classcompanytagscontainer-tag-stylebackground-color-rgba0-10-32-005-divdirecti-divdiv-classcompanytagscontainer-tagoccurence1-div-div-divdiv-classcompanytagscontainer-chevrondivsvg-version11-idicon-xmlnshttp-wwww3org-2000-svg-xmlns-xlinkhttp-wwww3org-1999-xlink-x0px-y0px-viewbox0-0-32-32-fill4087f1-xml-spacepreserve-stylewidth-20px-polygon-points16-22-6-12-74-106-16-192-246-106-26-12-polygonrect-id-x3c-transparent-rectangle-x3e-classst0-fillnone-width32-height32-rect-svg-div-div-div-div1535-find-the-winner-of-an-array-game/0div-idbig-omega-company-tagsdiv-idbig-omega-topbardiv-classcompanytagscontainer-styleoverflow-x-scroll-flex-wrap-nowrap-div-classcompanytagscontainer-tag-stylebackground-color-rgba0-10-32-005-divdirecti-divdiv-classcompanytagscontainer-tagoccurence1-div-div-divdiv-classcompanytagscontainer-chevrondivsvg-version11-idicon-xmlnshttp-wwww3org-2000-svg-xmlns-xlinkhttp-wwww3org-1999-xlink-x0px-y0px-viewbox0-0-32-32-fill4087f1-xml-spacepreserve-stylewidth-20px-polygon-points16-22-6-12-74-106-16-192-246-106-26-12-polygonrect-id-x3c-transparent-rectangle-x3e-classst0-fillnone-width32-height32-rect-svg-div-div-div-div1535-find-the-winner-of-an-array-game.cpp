class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        int maxElement = arr[0];
        queue<int> queue;
        for (int i = 1; i < arr.size(); i++) {
            maxElement = max(maxElement, arr[i]);
            queue.push(arr[i]);
        }
        
        int curr = arr[0];
        int winstreak = 0;
        
        while (!queue.empty()) {
            int opponent = queue.front();
            queue.pop();
            
            if (curr > opponent) {
                queue.push(opponent);
                winstreak++;
            } else {
                queue.push(curr);
                curr = opponent;
                winstreak = 1;
            }
            
            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }
        
        return -1;
    }
};