class Solution {
private:
    bool search(int row,int target,vector<vector<int>>& matrix) {
        int low = 0;
        int high = matrix[0].size() - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            cout<< matrix[row][mid] << endl;
            if(matrix[row][mid] > target) {
                high = mid - 1;
            } else if(matrix[row][mid] < target){
                low = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        for(int i = 0; i < n; i++) {
            if(search(i,target,matrix)) return true;
        }
        return false;
    }
};