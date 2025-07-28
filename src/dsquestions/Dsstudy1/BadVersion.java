package dsquestions.Dsstudy1;

public class BadVersion {
    public int firstBadVersion(int n) {
        int low=1;
        int high=n;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(isBadVersion(mid)){
                high=mid-1;
            }
            else{
                low=mid+1;

            }
        }
        return low;

    }
    public boolean isBadVersion(int x){
        return true;
    }
}
