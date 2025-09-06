package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class quantitative_average_aptitude extends AppCompatActivity {

    private TextView textView5;
    private TextView textview13;
    private EditText editTextNumber3;
    private Button button1;
    private Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quantitative_average_aptitude);

        textView5=findViewById(R.id.textView5);
        textview13=findViewById(R.id.textview13);
        editTextNumber3=findViewById(R.id.editTextNumber3);
        button1=findViewById(R.id.button1);
        button9=findViewById(R.id.button9);

        Random r = new Random();
        int s1=r.nextInt(4)+1;

        if(s1==1){
            q1();
        } else if (s1==2) {
            q2();
        } else if (s1==3) {
            q3();
        } else if (s1==4) {
            q4();
        }


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random r = new Random();
                int s1=r.nextInt(4)+1;

                if(s1==1){
                    q1();
                } else if (s1==2) {
                    q2();
                } else if (s1==3) {
                    q3();
                } else if (s1==4) {
                    q4();
                }

                textview13.setText("Try this one.");
            }
        });

    }
//==================================================================================================================================================
    public void q1(){

        editTextNumber3.setText("");

        Random r = new Random();
        int a=r.nextInt(16)+5;
        int b=r.nextInt(4)+3;
        int sumMultiples=0;

        for (int i = 1; i <= b; i++) {
            sumMultiples+=a*i;
        }

        int ans=sumMultiples/b;

        textView5.setText("Q. What is the average of first "+b+" multiples of "+a+" ?");

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNumber3.getText().toString().length()==0){
                    textview13.setText("Please enter your answer.");
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){
                    textview13.setText("Right Answer. your are doing good.\nClick Next to load the next question.");

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textview13.setText("Try this one.");

                            Random r = new Random();
                            int s1=r.nextInt(4)+1;

                            if(s1==1){
                                q1();
                            } else if (s1==2) {
                                q2();
                            } else if (s1==3) {
                                q3();
                            } else if (s1==4) {
                                q4();
                            }

                        }
                    });

                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    textview13.setText("Opps! Wrong Answer. Correct\nanswer is " + ans + ". Don't worry,\npractice makes a kid perfect.\nClick Next to load the next question.");

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textview13.setText("Try this one.");

                            Random r = new Random();
                            int s1=r.nextInt(4)+1;

                            if(s1==1){
                                q1();
                            } else if (s1==2) {
                                q2();
                            } else if (s1==3) {
                                q3();
                            } else if (s1==4) {
                                q4();
                            }

                        }
                    });

                }
            }
        });
    }


//==================================================================================================================================================
    public void q2(){

        editTextNumber3.setText("");

        Random r = new Random();
        int a=r.nextInt(16)+5;
        int b=r.nextInt(4)+3;
        int c=r.nextInt(4)+3;
        int ans=b*c;

        textView5.setText("Q. Average of "+a+" numbers is "+b+".\nIf each number is multiplied by "+c+",\nwhat will be the new average ?");

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNumber3.getText().toString().length()==0){
                    textview13.setText("Please enter your answer.");
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){
                    textview13.setText("Right Answer. your are doing good.\nClick Next to load the next question.");

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textview13.setText("Try this one.");

                            Random r = new Random();
                            int s1=r.nextInt(4)+1;

                            if(s1==1){
                                q1();
                            } else if (s1==2) {
                                q2();
                            } else if (s1==3) {
                                q3();
                            } else if (s1==4) {
                                q4();
                            }

                        }
                    });

                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    textview13.setText("Opps! Wrong Answer. Correct\nanswer is " + ans + ". Don't worry,\npractice makes a kid perfect.\nClick Next to load the next question.");

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textview13.setText("Try this one.");

                            Random r = new Random();
                            int s1=r.nextInt(4)+1;

                            if(s1==1){
                                q1();
                            } else if (s1==2) {
                                q2();
                            } else if (s1==3) {
                                q3();
                            } else if (s1==4) {
                                q4();
                            }

                        }
                    });

                }
            }
        });
    }

    //==================================================================================================================================================
    public void q3(){
        editTextNumber3.setText("");

        Random r = new Random();
        int a=r.nextInt(6)+5;
        int b=a+2;
        int c=a+4;
        int avg=(a+b+c)/3;
        int ans=c;

        textView5.setText("Q. If the average of 3 consecutive even\nnumbers is "+avg+",. Find the largesst\nof these numbers ?");

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNumber3.getText().toString().length()==0){
                    textview13.setText("Please enter your answer.");
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){
                    textview13.setText("Right Answer. your are doing good.\nClick Next to load the next question.");

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textview13.setText("Try this one.");

                            Random r = new Random();
                            int s1=r.nextInt(4)+1;

                            if(s1==1){
                                q1();
                            } else if (s1==2) {
                                q2();
                            } else if (s1==3) {
                                q3();
                            } else if (s1==4) {
                                q4();
                            }

                        }
                    });

                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    textview13.setText("Opps! Wrong Answer. Correct\nanswer is " + ans + ". Don't worry,\npractice makes a kid perfect.\nClick Next to load the next question.");

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textview13.setText("Try this one.");

                            Random r = new Random();
                            int s1=r.nextInt(4)+1;

                            if(s1==1){
                                q1();
                            } else if (s1==2) {
                                q2();
                            } else if (s1==3) {
                                q3();
                            } else if (s1==4) {
                                q4();
                            }

                        }
                    });

                }
            }
        });
    }
    //==================================================================================================================================================
    public void q4(){
    editTextNumber3.setText("");

        Random r = new Random();
        int a=r.nextInt(4)+3;
        int b=r.nextInt(31)+50;
        int c=r.nextInt(31)+50;
        int ans=(a*b)-((a-1)*c);

        String name="Sohan's";
        String subject="science";

        if(a==3){
            name="Ravi's";
            subject="SST";
        } else if (a==4) {
            name="Shivam's";
            subject="Hindi";
        } else if (a==5) {
            name="Dhruv's";
            subject="English";
        } else if (a==6) {
            name="Mohit's";
            subject="Maths";
        }

        textView5.setText("Q. Average of "+name+ " marks in "+a+" subjects\nis "+b+".If his average in "+(a-1)+" subjects\nincluding "+subject+" is "+c+",. How\nmany marks he obtained in "+subject +" ?");

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNumber3.getText().toString().length()==0){
                    textview13.setText("Please enter your answer.");
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){
                    textview13.setText("Right Answer. your are doing good.\nClick Next to load the next question.");

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textview13.setText("Try this one.");

                            Random r = new Random();
                            int s1=r.nextInt(4)+1;

                            if(s1==1){
                                q1();
                            } else if (s1==2) {
                                q2();
                            } else if (s1==3) {
                                q3();
                            } else if (s1==4) {
                                q4();
                            }

                        }
                    });

                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    textview13.setText("Opps! Wrong Answer. Correct\nanswer is " + ans + ". Don't worry,\npractice makes a kid perfect.\nClick Next to load the next question.");

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textview13.setText("Try this one.");

                            Random r = new Random();
                            int s1=r.nextInt(4)+1;

                            if(s1==1){
                                q1();
                            } else if (s1==2) {
                                q2();
                            } else if (s1==3) {
                                q3();
                            } else if (s1==4) {
                                q4();
                            }

                        }
                    });

                }
            }
        });
    }

    //==================================================================================================================================================
//    public void q5(){
//    editTextNumber3.setText("");
//
//        Random r = new Random();
//        int a=r.nextInt(16)+5;
//        int b=r.nextInt(4)+3;
//        int c=r.nextInt(4)+3;
//        int ans=b*c;
//
//        textView5.setText("Q. Average of "+a+" numbers is "+b+".\nIf each number is multiplied by "+c+",\nwhat will be the new average ?");
//
//        button9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(editTextNumber3.getText().toString().length()==0){
//                    textview13.setText("Please enter your answer.");
//                }
//                else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){
//                    textview13.setText("Right Answer. your are doing good.\nClick Next to load the next question.");
//
//                    button1.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            q1();
//                            textview13.setText("Try this one.");
//                        }
//                    });
//
//                }
//                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
//                    textview13.setText("Opps! Wrong Answer. Correct\nanswer is " + ans + ". Don't worry,\npractice makes a kid perfect.\nClick Next to load the next question.");
//
//                    button1.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            q1();
//                            textview13.setText("Try this one.");
//                        }
//                    });
//
//                }
//            }
//        });
//    }


}