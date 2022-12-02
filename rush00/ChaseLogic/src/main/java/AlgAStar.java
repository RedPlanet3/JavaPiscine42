import java.util.ArrayList;
import java.util.HashSet;

public class AlgAStar {
    //свободные ячейки 0, занятые 1(стены, враги, игрок)

    private int[][] arr;
    private Point start;
    private Point end;
    private Point current;
    private ArrayList<TrackPoint> trackList = new ArrayList<TrackPoint>();
    private ArrayList<Point> stopList = new ArrayList<Point>();
    private boolean gameWin = false;

    AlgAStar(int[][] arrIn, int[] start, int[] end)
    {
        this.arr = arrIn;
        this.start = new Point(start[0],start[1]);
        this.end = new Point(end[0],end[1]);
        this.current = this.start;
        fullStopList();
    }

    public int[] next()
    {
        boolean nextS = algorithm();
        if (!nextS)
            return new int[]{this.current.i, this.current.j};
        else
            return null;
    }

    public boolean answ()
    {
        return this.gameWin;
    }
    private void fullStopList()
    {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[j].length; i++) {
                if (arr[i][j] == 1)
                    stopList.add(new Point(i,j));
            }
        }
    }

    public void addTrack(Point point, int gravity)
    {
        this.trackList.add(new TrackPoint(point, gravity));
    }

    public void delTrack(TrackPoint trPoint)
    {
        this.trackList.remove(trPoint);
    }

    private int calcGravity(Point current)
    {
        int gravity = 0;
        gravity = Math.abs(current.i - this.end.i) + Math.abs(current.j - this.end.j);
        return gravity;
    }

    private boolean containsStopList(int i, int j)
    {
        for(Point e: this.stopList)
        {
            if(e.i == i && e.j == j)
                return true;
        }
        return false;
    }

    private boolean chechAvailable(int iC, int jC)
    {
        int len;
        if (iC != 0)
            len = this.arr.length;
        else
            len = this.arr[0].length;
        if ((this.current.i + iC == this.end.i) && (this.current.j + jC == this.end.j)) {
            gameWin = true;
            return true;
        }
        if ((iC != 0 ? this.current.i : this.current.i + iC != 0?iC:jC) < len &&
                (iC != 0 ? this.current.i : this.current.i + iC != 0?iC:jC) > -1 &&
                !containsStopList(this.current.i + iC, this.current.j + jC))
        {
            Point addPoint = new Point(this.current.i + iC, this.current.j  + jC);
            addTrack(addPoint, calcGravity(addPoint));
            return false;
        }
        else
            return false;
    }

    private boolean fullTrackList()
    {
        this.trackList.clear();
        if (chechAvailable(1, 0))
            return true;
        if (chechAvailable(-1, 0))
            return true;
        if (chechAvailable(0, 1))
            return true;
        if (chechAvailable(0, -1))
            return true;
        return false;
    }

    private boolean algorithm()
    {
        boolean finish = fullTrackList();
        if (finish)
            return true;
        if(this.trackList.size() == 0)
        {
            this.gameWin = false;
            return true;
        }
        Point nextPoint = this.trackList.get(0).point;
        int minGrav = this.trackList.get(0).grav;
        for (TrackPoint tr: this.trackList) {
            if (tr.grav < minGrav)
            {
                minGrav = tr.grav;
                nextPoint = tr.point;
            }
        }
        stopList.add(this.current);
        this.current = nextPoint;
        return false;
    }
}
