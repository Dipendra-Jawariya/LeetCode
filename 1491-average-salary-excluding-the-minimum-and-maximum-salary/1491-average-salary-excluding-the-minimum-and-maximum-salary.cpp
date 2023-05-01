class Solution {
public:
    double average(vector<int>& salary) {
        int minSalary = INT_MAX;
        int maxSalary INT_MIN;
        
        int sum = 0;
        for(int it : salary) {
            sum += it;
            minSalary = min(it,minSalary);
            maxSalary = max(it,maxSalary);
        }
        return (double)(sum - minSalary - maxSalary) / (double)(salary.size() - 2);
    }
};