package com.example.vis360;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;


public class POPUP extends Activity {
    Button back;
    Button next;
    TextView number;
    TextView title;
    RadioButton yes;
    RadioButton no;
    ProgressBar bar;
    Spinner spinner;
    Handler handler = new Handler();
    int epiloges[] = new int[10];

    TextView cov;
    TextView fl;
    TextView col;
    TableLayout table;
    Button leave;


    int corona = 0, flu = 0, cold = 0;

    int position = 1, last_Corona, last_Flu, last_Cold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_o_p_u_p);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .7), (int) (height * .3));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);


        back = (Button) findViewById(R.id.back_btn);
        next = (Button) findViewById(R.id.next_btn);
        number = (TextView) findViewById(R.id.number_txt);
        title = (TextView) findViewById(R.id.title_txt);
        yes = (RadioButton) findViewById(R.id.yes_radio);
        no = (RadioButton) findViewById(R.id.no_radio);
        bar = (ProgressBar) findViewById(R.id.bar);
        cov=(TextView)findViewById(R.id.covid_id_show);
        fl=(TextView)findViewById(R.id.flu_id_show);
        col=(TextView)findViewById(R.id.cold_id_show);
        table= (TableLayout)findViewById(R.id.bar2);
        leave=(Button)findViewById(R.id.leave_btn);

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        for (int i = 0; i < 10; i++) {
            epiloges[i] = 0;
        }

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no.setChecked(false);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes.setChecked(false);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextt();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backk();
            }
        });


    }

    void change_spinner_choices(){


    }
    void nextt() {
        if (yes.isChecked() || no.isChecked()) {

            if (position == 1) {

                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;
                    corona = corona + 3;
                    flu = flu + 3;
                    cold = cold + 1;
                }


                number.setText("2/10");
                title.setText("Do you have a 'Fever (over 38°) ?'");
            } else if (position == 2) {

                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;

                    corona = corona + 3;
                    flu = flu + 3;

                    cold = cold - 1;

                }

                number.setText("3/10");
                title.setText("Do you have a 'Stuffy nose ?'");
            } else if (position == 3) {

                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;

                    corona = corona - 1;
                    flu = flu + 2;
                    cold = cold + 3;
                }

                number.setText("4/10");
                title.setText("Do you have a 'Sore throat ?'");
            } else if (position == 4) {


                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;
                    corona = corona + 2;
                    flu = flu + 2;
                    cold = cold + 3;
                }

                number.setText("5/10");
                title.setText("Have you been experiencing \n      'Shortness of breath ?'");
            } else if (position == 5) {


                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;
                    corona = corona + 2;
                    flu = flu - 2;
                    cold = cold - 2;
                }


                number.setText("6/10");
                title.setText("Do you have 'Headaches ?'");
            } else if (position == 6) {


                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;
                    corona = corona + 2;
                    flu = flu +3 ;
                    cold = cold - 1;
                }


                number.setText("7/10");
                title.setText("Does your 'Body ache ?'");
            } else if (position == 7) {

                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;

                    corona = corona + 2;
                    flu = flu + 3;
                    cold = cold + 3;
                }


                number.setText("8/10");
                title.setText("Have you been 'Sneezing ?'");
            } else if (position == 8) {

                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;
                    corona = corona - 2;
                    flu = flu -2 ;
                    cold = cold + 3;
                }


                number.setText("9/10");
                title.setText("Do you feel 'Exhausted ?'");
            } else if (position == 9) {

                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;
                    corona = corona + 2;
                    flu = flu +3;
                    cold = cold + 2;
                }


                number.setText("10/10");
                title.setText("Do you have 'Diarrhea?'");
            } else if (position == 10) {

                if (yes.isChecked()) {
                    epiloges[position - 1] = 1;
                    corona = corona - 1;
                    flu = flu + 2;
                    cold = cold - 2;
                }

                back.setCursorVisible(false);
                next.setCursorVisible(false);

                yes.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                back.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                number.setVisibility(View.INVISIBLE);
                title.setText("Calculating results...");
                bar.setVisibility(View.VISIBLE);


                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        table.setVisibility(View.VISIBLE);
                        int pososto_covid;
                        int pososto_flu;
                        int pososto_cold;

                        if (corona>=0){
                            pososto_covid=(corona*100)/16;}
                        else{pososto_covid=0;}


                        if(flu>=0){
                            pososto_flu=(flu*100)/21;}
                        else{pososto_flu=0;}

                        if(cold>=0){
                            pososto_cold=(cold*100)/15;}
                        else{pososto_cold=0;}

                        title.setVisibility(View.INVISIBLE);

                        String coron= Integer.toString(pososto_covid);
                        String fll= Integer.toString(pososto_flu);
                        String cool= Integer.toString(pososto_cold);

                        if (pososto_covid>=70){
                            cov.setTextColor(Color.RED);
                        }
                        if (pososto_flu>=70){
                            fl.setTextColor(Color.RED);
                        }
                        if (pososto_cold>=70){
                            col.setTextColor(Color.RED);
                        }

                        if (pososto_covid<=20){
                            cov.setTextColor(Color.GREEN);
                        }
                        if (pososto_flu<=20){
                            fl.setTextColor(Color.GREEN);
                        }
                        if (pososto_cold<=20){
                            col.setTextColor(Color.GREEN);
                        }

                        cov.setText(coron+"%");
                        fl.setText(fll+"%");
                        col.setText(cool+"%");





                        bar.setVisibility(View.INVISIBLE);

                    }
                }, 3000);   //5 seconds


            }

            yes.setChecked(false);
            no.setChecked(false);


            position = position + 1;
        }


    }

    void backk() {

        if (position > 1) {
            yes.setChecked(false);
            no.setChecked(false);
            position = position - 1;
            if (position == 1) {

                if (epiloges[position - 1] == 1) {
                    corona = corona - 3;
                    flu = flu - 3;
                    cold = cold - 1;
                }


                number.setText("1/10");
                title.setText("Have you been 'Coughing (dry cough) ?'");
            } else if (position == 2) {

                if (epiloges[position - 1] == 1) {
                    corona = corona - 3;
                    flu = flu - 3;
                    cold = cold + 1;
                }


                number.setText("2/10");
                title.setText("Do you have a 'Fever (over 38°) ?'");
            } else if (position == 3) {

                if (epiloges[position - 1] == 1) {
                    corona = corona + 1;
                    flu = flu - 2;
                    cold = cold - 3;
                }


                number.setText("3/10");
                title.setText("Do you have a 'Stuffy nose?'");
            } else if (position == 4) {

                if (epiloges[position - 1] == 1) {
                    corona = corona - 2;
                    flu = flu - 2;
                    cold = cold - 3;
                }


                number.setText("4/10");
                title.setText("Do you have a 'Sore throat?'");
            } else if (position == 5) {

                if (epiloges[position - 1] == 1) {
                    corona = corona - 2;
                    flu = flu + 2;
                    cold = cold + 2;
                }


                number.setText("5/10");
                title.setText("Have you been experiencing \n      'Shortness of breath ?'");
            } else if (position==6) {
                System.out.println("blablablabla");

                if (epiloges[position - 1] == 1) {
                    corona = corona - 2;

                    flu = flu-3;
                    cold=cold+1;

                }


                number.setText("6/10");
                title.setText("Do you have 'Headaches ?'");
            } else if (position == 7) {

                if (epiloges[position - 1] == 1) {
                    corona = corona - 2;
                    flu = flu - 3;
                    cold = cold - 3;
                }


                number.setText("7/10");
                title.setText("Does your 'Body ache ?'");
            } else if (position == 8) {

                if (epiloges[position - 1] == 1) {
                    corona = corona + 2;
                    flu = flu + 2;
                    cold = cold - 3;
                }


                number.setText("8/10");
                title.setText("Have you been 'Sneezing ?'");
            } else if (position == 9) {

                if (epiloges[position - 1] == 1) {
                    corona = corona - 2;
                    flu = flu - 3;
                    cold = cold - 2;
                }


                number.setText("9/10");
                title.setText("Do you feel 'Exhausted ?'");
            }


            epiloges[position-1]=0;
        }
        System.out.println("Blabli: "+corona+"  "+flu+"  "+cold+"  "+position);
    }


}
