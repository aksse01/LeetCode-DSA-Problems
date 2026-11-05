class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        int ans=0;
        unordered_map<long long,int>mp;
        for (int i=0;i<wall.size();i++){
            long long x=0;
            for (int j=0;j<wall[i].size()-1;j++){
                x+=wall[i][j];
                mp[x]++;
            }
        }
        for (auto &it:mp){ans=max(ans,it.second);}
        return wall.size()-ans;
    }
};