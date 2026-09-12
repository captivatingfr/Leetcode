class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size();
        int[][] arr=new int[n][4];
        for(int i=0;i<n;i++){
            arr[i][0]=intervals.get(i).get(0);
            arr[i][1]=intervals.get(i).get(1);
            arr[i][2]=intervals.get(i).get(2);
            arr[i][3]=i;
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int[] next=new int[n];
        for(int i=0;i<n;i++){
            int l=i+1;
            int r=n;
            while(l<r){
                int mid=(l+r)/2;
                if(arr[mid][0]>arr[i][1]){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }
            next[i]=l;
        }
        long[][] dp=new long[n+1][5];
        int[][][] path=new int[n+1][5][4];
        for(int i=0;i<=n;i++){
            for(int j=0;j<5;j++){
                Arrays.fill(path[i][j],n);
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=4;j++){
                long skip=dp[i+1][j];
                long take=arr[i][2]+dp[next[i]][j-1];
                if(take>skip){
                    dp[i][j]=take;
                    for(int x=0;x<4;x++){
                        path[i][j][x]=path[next[i]][j-1][x];
                    }
                    for(int x=0;x<4;x++){
                        if(path[i][j][x]==n){
                            path[i][j][x]=arr[i][3];
                            break;
                        }
                    }
                    Arrays.sort(path[i][j]);
                }else if(take<skip){
                    dp[i][j]=skip;

                    for(int x=0;x<4;x++){
                        path[i][j][x]=path[i+1][j][x];
                    }
                }else{
                    dp[i][j]=take;

                    int[] a=new int[4];
                    int[] b=new int[4];

                    for(int x=0;x<4;x++){
                        a[x]=path[next[i]][j-1][x];
                        b[x]=path[i+1][j][x];
                    }

                    for(int x=0;x<4;x++){
                        if(a[x]==n){
                            a[x]=arr[i][3];
                            break;
                        }
                    }
                    Arrays.sort(a);
                    boolean smaller=false;
                    for(int x=0;x<4;x++){
                        if(a[x]<b[x]){
                            smaller=true;
                            break;
                        }

                        if(a[x]>b[x]){
                            break;
                        }
                    }
                    if(smaller){
                        for(int x=0;x<4;x++){
                            path[i][j][x]=a[x];
                        }
                    }else{
                        for(int x=0;x<4;x++){
                            path[i][j][x]=b[x];
                        }
                    }
                }
            }
        }
        int count=0;
        while(count<4 && path[0][4][count]!=n){
            count++;
        }
        int[] ans=new int[count];
        for(int i=0;i<count;i++){
            ans[i]=path[0][4][i];
        }
        return ans;
    }
}