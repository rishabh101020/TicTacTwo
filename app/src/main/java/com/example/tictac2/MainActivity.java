

package com.example.tictac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

class Btn {
    boolean Initial = true , Occupied = false , Leaving = false;
    int occp=-1;
    int levb=-1;

    public void setInitial(boolean initial) {
        Initial = initial;
        Occupied = !initial;
        Leaving = !initial;
    }

    public void setOccupied(boolean occupied) {
        Initial = !occupied;
        Occupied = occupied;
        Leaving = !occupied;
    }

    public void setLeaving(boolean leaving) {
        Initial = !leaving;
        Occupied = !leaving;
        Leaving = leaving;
    }
}

class Player{
    int id;
    int avail;

    Player(int id){
        this.id =id;
        avail =3;
    }
}

public class MainActivity extends AppCompatActivity {

    int c =0;
    int won =-1;

    View.OnTouchListener TouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);

            return true;
        }
    };

    public void change(Player[] P,ImageView[] button,Btn[] btn,View hap1,View hbp2,View vlp1,View vrp1,View vlp2,View vrp2,ImageView [][] availCor){
        if(won != -1){

                Toast.makeText(this,"Player " + (c+1) +" WON!",Toast.LENGTH_SHORT).show();
                for(int i=0;i<9;i++){
                    if(button[i].isEnabled()){
//                        button[i].setBackgroundColor(Color.RED);
                        button[i].setEnabled(false);
                    }
                }

                for(int i=0;i<2;i++){
                    for(int j=0;j<3;j++){
                        availCor[i][j].setEnabled(false);
                    }
                }
/*
            if(won == 1)
            {
                availCor[0][0].setText("w");
                availCor[0][1].setText("o");
                availCor[0][2].setText("n");
            }

            else if(won == 2){
                availCor[1][0].setText("w");
                availCor[1][1].setText("o");
                availCor[1][2].setText("n");
            }
*/
        }
        else{

//            availCor[c][P[c].avail].setVisibility(View.INVISIBLE);
//            availCor[c][P[c].avail].setEnabled(false);

            if (c == 1)
            {

//                if(P[0].avail-1>=0)
                availCor[0][0].setEnabled(true);
                availCor[0][1].setEnabled(true);
                availCor[0][2].setEnabled(true);
                availCor[1][0].setEnabled(false);
                availCor[1][1].setEnabled(false);
                availCor[1][2].setEnabled(false);

                hap1.setBackgroundColor(getResources().getColor(R.color.red));
                vlp1.setBackgroundColor(getResources().getColor(R.color.red));
                vrp1.setBackgroundColor(getResources().getColor(R.color.red));

                hbp2.setBackgroundColor(getResources().getColor(R.color.black));
                vlp2.setBackgroundColor(getResources().getColor(R.color.black));
                vrp2.setBackgroundColor(getResources().getColor(R.color.black));
                c = 0;

                for(int i=0;i<9;i++){
                    if(btn[i].Initial){
                        if(P[c].avail >=1)
                        {
                            button[i].setEnabled(true);
                            button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
                        }
                        else if(P[c].avail == 0){
                            button[i].setEnabled(false);
                            button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));

                        }
                    }

                    else if(btn[i].Occupied){
                        if(btn[i].occp == c){
                            button[i].setEnabled(true);
                            button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb0));
                            button[i].setOnDragListener(new View.OnDragListener() {
                                @Override
                                public boolean onDrag(View v, DragEvent event) {
                                    return false;
                                }
                            });
                        }
                        else{
                            button[i].setEnabled(false);
                            button[i].setBackgroundColor(getResources().getColor(R.color.OccDis1));
                        }
                    }
                }
            }
            else
            {

                availCor[0][0].setEnabled(false);
                availCor[0][1].setEnabled(false);
                availCor[0][2].setEnabled(false);
                availCor[1][0].setEnabled(true);
                availCor[1][1].setEnabled(true);
                availCor[1][2].setEnabled(true);
                c = 1;

                hap1.setBackgroundColor(getResources().getColor(R.color.black));
                vlp1.setBackgroundColor(getResources().getColor(R.color.black));
                vrp1.setBackgroundColor(getResources().getColor(R.color.black));

                hbp2.setBackgroundColor(getResources().getColor(R.color.red));
                vlp2.setBackgroundColor(getResources().getColor(R.color.red));
                vrp2.setBackgroundColor(getResources().getColor(R.color.red));

                for(int i=0;i<9;i++){
                    if(btn[i].Initial){
                        if(P[c].avail >=1)
                        {
                            button[i].setEnabled(true);
                            button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));

                        }
                        else if(P[c].avail == 0){
                            button[i].setEnabled(false);
                            button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
                        }
                    }

                    else if(btn[i].Occupied){
                        if(btn[i].occp == c){
                            button[i].setEnabled(true);
                            button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb1));
                            button[i].setOnDragListener(new View.OnDragListener() {
                                @Override
                                public boolean onDrag(View v, DragEvent event) {
                                    return false;
                                }
                            });
                        }
                        else{
                            button[i].setEnabled(false);
                            button[i].setBackgroundColor(getResources().getColor(R.color.OccDis0));
                        }
                    }
                }
            }
        }
    }

    public int checkWin(int i,Btn[] btn){

        if(i == 0){

            if ((btn[1].occp == c && btn[2].occp == c) || (btn[3].occp == c && btn[6].occp == c) || (btn[4].occp == c && btn[8].occp == c)) {
                return c + 1;
            }
        }

        else if(i == 1){

            if ((btn[0].occp == c && btn[2].occp == c) || (btn[4].occp == c && btn[7].occp == c)) {
                return c + 1;
            }

        }
        else if(i == 2){

            if ((btn[1].occp == c && btn[0].occp == c) || (btn[4].occp == c && btn[6].occp == c) || (btn[5].occp == c && btn[8].occp == c)){
                return c + 1;
            }
        }
        else if(i == 3){

            if ((btn[0].occp == c && btn[6].occp == c) || (btn[4].occp == c && btn[5].occp == c)) {
                return c + 1;
            }
        }
        else if(i == 4){

            if ((btn[1].occp == c && btn[7].occp == c)  || (btn[3].occp == c && btn[5].occp == c) || (btn[0].occp == c && btn[8].occp == c) || (btn[2].occp == c && btn[6].occp == c)) {
                return c + 1;
            }

        }
        else if(i == 5){

            if ((btn[8].occp == c && btn[2].occp == c) || (btn[3].occp == c && btn[4].occp == c) ){
                return c + 1;
            }
        }
        else if(i == 6){

            if ((btn[4].occp == c && btn[2].occp == c)  || (btn[3].occp == c && btn[0].occp == c) ||(btn[7].occp == c && btn[8].occp == c)) {
                return c + 1;
            }
        }
        else if(i == 7){

            if ((btn[1].occp == c && btn[4].occp == c) || (btn[6].occp == c && btn[8].occp == c) ){
                return c + 1;
            }
        }
        else if(i == 8){

            if ((btn[5].occp == c && btn[2].occp == c) || (btn[7].occp == c && btn[6].occp == c) || (btn[4].occp == c && btn[0].occp == c)) {
                return c + 1;
            }
        }

        return -1;
    }

    public void check(int j,int i,ImageView[] button ){
        if(j == 0){

            if(i==1 || i==3 || i==4){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
        else if(j == 1){
            if(i==0 || i==3 || i==4 || i==5 || i==2){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
        else if(j == 2){
            if(i==1 || i==5 || i==4){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
        else if(j == 3){

            if(i==1 || i==0 || i==4 || i==7 || i==6){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
        else if(j == 4){

            if(i==0 || i==1 || i==2|| i==3 || i==4 ||i==5 || i==6 || i==7 || i==8){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
        else if(j == 5){

            if(i==1 || i==2 || i==4 || i==7 || i==8){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
        else if(j == 6){

            if(i==7 || i==3 || i==4){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
        else if(j == 7){

            if(i==5 || i==3 || i==4 || i==6 || i==8){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
        else if(j == 8){
            if(i==7 || i==5 || i==4){
                button[i].setEnabled(true);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            }
            else{
                button[i].setEnabled(false);
                button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
            }
        }
    }

    public void running(int k,Player[] P, ImageView[] button, Btn[] btn,View hap1,View hbp2,View vlp1,View vrp1,View vlp2,View vrp2,ImageView [][] availCor){

        boolean flag = true;

        for(int i = 0;i<9;i++)
        {
            if(btn[i].Leaving)
            {
                flag = false;
                btn[i].setInitial(true);
                btn[i].levb = -1;

                if(P[c].avail >=1)
                {
                    button[i].setEnabled(true);
                    button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
                }
                else if(P[c].avail == 0){
                    button[i].setEnabled(false);
                    button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
                }


            }
        }
        btn[k].setOccupied(true);
        btn[k].occp = c;
        if(c==0)
            button[k].setBackgroundColor(getResources().getColor(R.color.OccEnb0));
        else if(c==1)
            button[k].setBackgroundColor(getResources().getColor(R.color.OccEnb1));

        if(P[c].avail >= 1)
        {
            if(flag)
            {
                P[c].avail--;
            }
            for(int i = 0;i<9;i++)
            {
                if(btn[i].Initial){
                    button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
                }

                else if(btn[i].Occupied && btn[i].occp == c)
                {
                    button[i].setEnabled(true);
                    if(c==0)
                        button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb0));
                    else if(c==1)
                        button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb1));
                }
            }
        }
        if(P[c].avail == 0){
            for(int i = 0;i<9;i++)
            {
                if(btn[i].Initial && button[i].isEnabled()){
                    button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
                }

                else if(btn[i].Occupied && btn[i].occp == c)
                {
                    button[i].setEnabled(true);
                    if(c==0)
                        button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb0));
                    else if(c==1)
                        button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb1));
                }
            }

            won = checkWin(k,btn);

        }

            change(P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
    }

    public void TouchWork(int j,Player[] P,Btn[] btn, ImageView[] button){
        btn[j].setLeaving(true);
        btn[j].occp=-1;
        button[j].setBackgroundColor(getResources().getColor(R.color.Lev));
        btn[j].levb = c;

        for(int i = 0;i<9;i++)
        {
            if(btn[i].Occupied && button[i].isEnabled() && btn[i].occp == c){
                button[i].setEnabled(false);
                if(c==0)
                    button[i].setBackgroundColor(getResources().getColor(R.color.OccDis0));
                else if(c==1)
                    button[i].setBackgroundColor(getResources().getColor(R.color.OccDis1));
            }

             if(btn[i].Initial ){
                check(j,i,button);
            }
        }

        button[j].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                int action = event.getAction();
                ImageView vBtn = (ImageView) v;
                final ImageView viewSta = (ImageView) event.getLocalState();
                int id = viewSta.getId();

                switch (action){
                    case DragEvent.ACTION_DRAG_ENDED:
                        btn[j].setOccupied(true);
                        btn[j].occp = c;
                        btn[j].levb = -1;
                        if(c==0)
                            button[j].setBackgroundColor(getResources().getColor(R.color.OccEnb0));
                        else if(c==1)
                            button[j].setBackgroundColor(getResources().getColor(R.color.OccEnb1));

                        if(P[c].avail >= 1)
                        {
                            for(int i = 0;i<9;i++)
                            {
                                if(btn[i].Initial){
                                    button[i].setEnabled(true);
                                    button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
                                }

                                else if(btn[i].Occupied && btn[i].occp == c)
                                {
                                    button[i].setEnabled(true);
                                    if(c==0)
                                        button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb0));
                                    else if(c==1)
                                        button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb1));
                                }
                            }
                        }
                        if(P[c].avail == 0){
                            for(int i = 0;i<9;i++)
                            {
                                if(btn[i].Initial && button[i].isEnabled()){
                                    button[i].setEnabled(false);
                                    button[i].setBackgroundColor(getResources().getColor(R.color.InitDis));
                                }

                                else if(btn[i].Occupied && btn[i].occp == c)
                                {
                                    button[i].setEnabled(true);
                                    if(c==0)
                                        button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb0));
                                    else if(c==1)
                                        button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb1));
                                }
                            }


                        }
                        viewSta.setOnDragListener(new View.OnDragListener() {
                            @Override
                            public boolean onDrag(View v, DragEvent event) {
                                return false;
                            }
                        });
                        break;
                }

                return true;
            }
        });
    }

    public void DragWork(int j,View v,DragEvent event,Player[] P, ImageView[] button, Btn[] btn,View hap1,View hbp2,View vlp1,View vrp1,View vlp2,View vrp2,ImageView [][] availCor){
        int action = event.getAction();
        ImageView vBtn = (ImageView) v;
        final ImageView viewSta = (ImageView) event.getLocalState();
        int id = viewSta.getId();

        switch (action){

            case DragEvent.ACTION_DRAG_ENTERED:
                button[j].setBackgroundColor(getResources().getColor(R.color.white));
                break;

            case DragEvent.ACTION_DRAG_EXITED:
                button[j].setBackgroundColor(getResources().getColor(R.color.InitEnb));
                break;

            case DragEvent.ACTION_DROP:
                if(id == R.id.p11 || id == R.id.p12 || id == R.id.p13 )
                {
                    running(j,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                    vBtn.setImageResource(R.drawable.family_son);
//                    viewSta.setVisibility(View.INVISIBLE);
                }
                else if(id == R.id.p21 || id == R.id.p22 || id == R.id.p23 )
                {
                    running(j,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                    vBtn.setImageResource(R.drawable.family_daughter);
//                    viewSta.setVisibility(View.INVISIBLE);
                }

                else{

//                    Btn bt;
                    int a;
                    if(id == R.id.imageButton0)
                        a=0;

                    else if(id == R.id.imageButton1)
//                        bt = btn[1];
                        a=1;
                    else if(id == R.id.imageButton2)
//                        bt = btn[2];
                        a=2;
                    else if(id == R.id.imageButton3)
//                        bt = btn[3];
                        a=3;
                    else if(id == R.id.imageButton4)
//                        bt = btn[4];
                        a=4;
                    else if(id == R.id.imageButton5)
//                        bt = btn[5];
                        a=5;
                    else if(id == R.id.imageButton6)
//                        bt = btn[6];
                        a=6;
                    else if(id == R.id.imageButton7)
//                        bt = btn[7];
                        a=7;
                    else
//                        bt = btn[8];
                        a=8;
                    if(btn[a].levb == 0){
                        running(j,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                        vBtn.setImageResource(R.drawable.family_son);
                    }
                    else if(btn[a].levb == 1) {
                        running(j, P, button, btn, hap1, hbp2, vlp1, vrp1, vlp2, vrp2, availCor);
                        vBtn.setImageResource(R.drawable.family_daughter);
                    }

                    viewSta.setOnDragListener(new View.OnDragListener() {
                        @Override
                        public boolean onDrag(View v, DragEvent event) {
                            DragWork(a,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                            return true;
                        }
                    });
                }

                viewSta.setImageResource(0);
                viewSta.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                    }
                });

                button[j].setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        ClipData data = ClipData.newPlainText("","");
                        View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                        v.startDrag(data,myShadowBuilder,v,0);

                        TouchWork(j,P,btn,button);
                        return true;
                    }
                });
                break;
        }
    }


//
//    View.OnTouchListener TouchListenerB = new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View v) {
//
//
//            ClipData data = ClipData.newPlainText("","");
//            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
//            v.startDrag(data,myShadowBuilder,v,0);
//
//            return true;
//        }
//    };

//    View.OnDragListener dragAvail = new View.OnDragListener() {
//        @Override
//        public boolean onDrag(View v, DragEvent event) {
//
//            int action = event.getAction();
//            ImageView vBtn = (ImageView) v;
//            final ImageView viewSta = (ImageView) event.getLocalState();
//            int id = viewSta.getId();
//
//            switch (action){
//                case DragEvent.ACTION_DRAG_STARTED:
//                    for(int i= 0)
//            }
//            return true;
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d("MAINACTIVITY","came here");

        Player[] P = new Player[2];
        P[0] = new Player(0);
        P[1] = new Player(1);

        ImageView[] button = new ImageView[9];

        button[0] = findViewById(R.id.imageButton0);
        button[1] = findViewById(R.id.imageButton1);
        button[2] = findViewById(R.id.imageButton2);
        button[3] = findViewById(R.id.imageButton3);
        button[4] = findViewById(R.id.imageButton4);
        button[5] = findViewById(R.id.imageButton5);
        button[6] = findViewById(R.id.imageButton6);
        button[7] = findViewById(R.id.imageButton7);
        button[8] = findViewById(R.id.imageButton8);

        View hap1 = findViewById(R.id.hap1);
        View hbp2 = findViewById(R.id.hbp2);
        View vlp1 = findViewById(R.id.vlp1);
        View vrp1 = findViewById(R.id.vrp1);
        View vlp2 = findViewById(R.id.vlp2);
        View vrp2 = findViewById(R.id.vrp2);

        Btn[] btn = new Btn[9];

        for(int i=0;i<9;i++){
            button[i].setBackgroundColor(getResources().getColor(R.color.InitEnb));
            btn[i] = new Btn();
        }

        ImageView [][] availCor = new ImageView[2][3];

        availCor[0][0] = findViewById(R.id.p11);
        availCor[0][1] = findViewById(R.id.p12);
        availCor[0][2] = findViewById(R.id.p13);
        availCor[1][0] = findViewById(R.id.p21);
        availCor[1][0].setEnabled(false);
        availCor[1][1] = findViewById(R.id.p22);
        availCor[1][1].setEnabled(false);
        availCor[1][2] = findViewById(R.id.p23);
        availCor[1][2].setEnabled(false);

        availCor[0][0].setOnTouchListener(TouchListener);
        availCor[0][1].setOnTouchListener(TouchListener);
        availCor[0][2].setOnTouchListener(TouchListener);
        availCor[1][0].setOnTouchListener(TouchListener);
        availCor[1][1].setOnTouchListener(TouchListener);
        availCor[1][2].setOnTouchListener(TouchListener);

        availCor[0][0].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","this began");
                int action = event.getAction();
                ImageView vBtn = (ImageView) v;
                final ImageView viewSta = (ImageView) event.getLocalState();
                int id = viewSta.getId();

                switch (action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        for(int i= 0;i<9;i++){
                            if(button[i].isEnabled() && btn[i].occp == 0)
                                button[i].setBackgroundColor(getResources().getColor(R.color.OccDis0));

//                            else if(button[i].isEnabled() && btn[i].occp == 1)
//                                button[i].setBackgroundColor(getResources().getColor(R.color.OccDis1));
                        }
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        for(int i= 0;i<9;i++){
                            if(button[i].isEnabled() && btn[i].occp == 0)
                                button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb0));

                            else if(button[i].isEnabled() && btn[i].occp == 1)
                                button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb1));
                        }
                }
                return true;
            }
        } );

        availCor[1][0].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","this began");
                int action = event.getAction();
                ImageView vBtn = (ImageView) v;
                final ImageView viewSta = (ImageView) event.getLocalState();
                int id = viewSta.getId();

                switch (action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        for(int i= 0;i<9;i++){
//                            if(button[i].isEnabled() && btn[i].occp == 0)
//                                button[i].setBackgroundColor(getResources().getColor(R.color.OccDis0));

                            if(button[i].isEnabled() && btn[i].occp == 1)
                                button[i].setBackgroundColor(getResources().getColor(R.color.OccDis1));
                        }
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        for(int i= 0;i<9;i++){
                            if(button[i].isEnabled() && btn[i].occp == 0)
                                button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb0));

                            else if(button[i].isEnabled() && btn[i].occp == 1)
                                button[i].setBackgroundColor(getResources().getColor(R.color.OccEnb1));
                        }
                }
                return true;
            }
        } );

        button[0].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","0 began");
                DragWork(0,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });

        button[1].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","1 began");
                DragWork(1,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });

        button[2].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","2 began");
                DragWork(2,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });

        button[3].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","3 began");

                DragWork(3,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });

        button[4].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","4 began");

                DragWork(4,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });

        button[5].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","5 began");

                DragWork(5,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });

        button[6].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","6 began");

                DragWork(6,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });

        button[7].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","7 began");

                DragWork(7,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });

        button[8].setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.d("ONdragStarted","8 began");

                DragWork(8,v, event,P,button,btn,hap1,hbp2,vlp1,vrp1,vlp2,vrp2,availCor);
                return true;
            }
        });
    }
}