#include <iostream>
#include <vector>
#include <cmath>
#include <set>
#include <string>
#include <stack>
#include <map>
#include <set>
#include <iterator>
#include <queue>


using namespace std;



int main(){
    int t = 1;
    while(true){
        int n;
        cin>>n;

        if (n==0){
            break;
        }

        int board[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cin>>board[i][j];
            }
        }

        int value[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                value[i][j] = 2100000000;
            }
        }

        value[0][0] = board[0][0];

        queue<pair<int,int>> queue ;
        queue.push({0,0});

        while(!queue.empty()){
            pair<int,int> cur = queue.front();
            queue.pop();

            int dy[] = {1,-1,0,0};
            int dx[] = {0,0,1,-1};

            for (int i = 0; i < 4; ++i) {
                int nx = dx[i]+cur.first;
                int ny = dy[i]+cur.second;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }

                int nextValue = value[cur.first][cur.second] + board[nx][ny];
                if (nextValue < value[nx][ny]){
                    value[nx][ny] = nextValue;
                    queue.push({nx,ny});
                }
            }
        }
        cout<<"Problem "<<t<<": "<<value[n-1][n-1]<<endl;
        t++;
    }
}
