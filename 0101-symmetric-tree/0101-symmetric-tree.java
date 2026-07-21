/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    void levelorder(TreeNode* root , vector<vector<int>>& ans){
        if(root == nullptr) return;

        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()){
            int size = q.size();
            vector<int> level;

            for(int i = 0; i < size; i++){
                TreeNode* node = q.front();
                q.pop();

                if(node == nullptr){
                    level.push_back(101);
                    continue;
                }

                level.push_back(node->val);

                if(node->left) q.push(node->left);
                else q.push(nullptr);

                if(node->right) q.push(node->right);
                else q.push(nullptr);
            }

            ans.push_back(level);
        }

        ans.pop_back();
    }

public:
    bool isSymmetric(TreeNode* root) {
        vector<vector<int>> ans;
        levelorder(root, ans);

        for(auto &level : ans){
            int l = 0;
            int r = level.size() - 1;

            while(l <= r){
                if(level[l] != level[r]){
                    return false;
                }
                l++;
                r--;
            }
        }

        return true;
    }
};