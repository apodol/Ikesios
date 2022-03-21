package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Demographics extends AppCompatActivity {

    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14;
    RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,radioGroup5;
    TextInputLayout xora_field;
    TextInputLayout tk_field;
    EditText text2;
    Button submit;
    static List<Integer> list = new ArrayList<Integer>();
    static List<Integer> list_Ind = new ArrayList<Integer>();
    static List<String> list_Radio=new ArrayList<String>();
    TextInputLayout age;
    Context ta=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demographics);


        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkbox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkbox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkbox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkbox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkbox9);
        checkBox10 = (CheckBox) findViewById(R.id.checkbox10);
        checkBox11 = (CheckBox) findViewById(R.id.checkbox11);
        checkBox12 = (CheckBox) findViewById(R.id.checkbox12);
        checkBox13 = (CheckBox) findViewById(R.id.checkbox13);
        checkBox14 = (CheckBox) findViewById(R.id.checkbox14);
        radioGroup1 = (RadioGroup) findViewById(R.id.groupradio);
        radioGroup2 = (RadioGroup) findViewById(R.id.groupradio1);
        radioGroup3 = (RadioGroup) findViewById(R.id.groupradio2);
        radioGroup4 = (RadioGroup) findViewById(R.id.groupradio3);
        radioGroup5 = (RadioGroup) findViewById(R.id.groupradio4);

        xora_field=(TextInputLayout) findViewById(R.id.town);
        tk_field=(TextInputLayout) findViewById(R.id.tk);
        text2=(EditText) findViewById(R.id.roomates);
        submit = (Button) findViewById(R.id.register2);
        age=(TextInputLayout)findViewById(R.id.age);
     /*  // NumberPicker np = findViewById(R.id.numberPicker);
        np.setMinValue(18);
        np.setMaxValue(110);

        np.setOnValueChangedListener(onValueChangeListener);
    }
*/

  /*  NumberPicker.OnValueChangeListener onValueChangeListener =
            new 	NumberPicker.OnValueChangeListener(){
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    Toast.makeText(Demographics.this,
                            "selected number "+numberPicker.getValue(), Toast.LENGTH_SHORT);
                }
            };*/


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedRadioButton=(RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId());
                String group=selectedRadioButton.getText().toString();

                RadioButton selectedRadioButton1=(RadioButton)findViewById(radioGroup2.getCheckedRadioButtonId());
                String group1=selectedRadioButton1.getText().toString();

                RadioButton selectedRadioButton2=(RadioButton)findViewById(radioGroup3.getCheckedRadioButtonId());
                String group2=selectedRadioButton2.getText().toString();

                RadioButton selectedRadioButton3=(RadioButton)findViewById(radioGroup4.getCheckedRadioButtonId());
                String group3=selectedRadioButton3.getText().toString();

                RadioButton selectedRadioButton4=(RadioButton)findViewById(radioGroup5.getCheckedRadioButtonId());
                String group4=selectedRadioButton4.getText().toString();

                int group1int=0,group2int=0,group3int=0,group4int=0,group5int=0;
                if (group.contains("Γυμ"))
                    group1int=10;
                else if (group.contains("Λύκ"))
                    group1int=15;
                else if (group.contains("Πτυ"))
                    group1int=20;
                else if (group.contains("Μάστ"))
                    group1int=25;
                else if (group.contains("Διδ"))
                    group1int=30;
                else if (group.contains("Άλ"))
                    group1int=35;

                if(group1.contains("Αρσ"))
                    group2int=10;
                else if (group1.contains("Θηλ"))
                    group2int=15;

                if (group2.contains("Συμβ"))
                    group3int=10;
                else if (group2.contains("ΣΣ"))
                    group3int=15;
                else if (group2.contains("Άγαμ"))
                    group3int=20;
                else if (group2.contains("παιδ"))
                    group3int=25;
                else if (group2.contains("Αλλο"))
                    group3int=30;

                if (group3.contains("Δημ"))
                    group4int=10;
                else if (group3.contains("Ιδι"))
                    group4int=15;
                else if (group3.contains("Αυτο"))
                    group4int=20;
                else if (group3.contains("Άνεργος"))
                    group4int=30;
                else if (group3.contains("Φοιτ"))
                    group4int=25;
                else if (group3.contains("Αλλο"))
                    group4int=35;

                if (group4.contains("έως"))
                    group5int=10;
                else if (group4.contains("500 - 1000"))
                    group5int=15;
                else if (group4.contains("1000 - 2000"))
                    group5int=20;
                else if (group4.contains("2000 - 4000"))
                    group5int=25;
                else if (group4.contains("άνω"))
                    group5int=30;


                List<Integer> list_sxeseis=new ArrayList<>();
                List<Integer> list_klados=new ArrayList<>();
                if (checkBox1.isChecked())
                    list_sxeseis.add(10);
                if (checkBox2.isChecked())
                    list_sxeseis.add(15);
                if (checkBox3.isChecked())
                    list_sxeseis.add(20);
                if (checkBox4.isChecked())
                    list_sxeseis.add(30);
                if (checkBox5.isChecked())
                    list_sxeseis.add(35);

                if (checkBox6.isChecked())
                    list_klados.add(10);
                if (checkBox7.isChecked())
                    list_klados.add(15);
                if (checkBox8.isChecked())
                    list_klados.add(20);
                if (checkBox9.isChecked())
                    list_klados.add(25);
                if (checkBox10.isChecked())
                    list_klados.add(30);
                if (checkBox11.isChecked())
                    list_klados.add(35);
                if (checkBox12.isChecked())
                    list_klados.add(40);
                if (checkBox13.isChecked())
                    list_klados.add(45);
                if (checkBox14.isChecked())
                    list_klados.add(50);

                JSONObject jsonParam = new JSONObject();


                JSONObject test1 = new JSONObject();
                JSONObject test2 = new JSONObject();


                JSONArray sxeseis = new JSONArray();
                JSONArray klados = new JSONArray();

                String xora=xora_field.getEditText().getText().toString();
                int tk = Integer.parseInt(tk_field.getEditText().getText().toString());

                try {
                    for (int num : list_sxeseis){

                        JSONObject test = new JSONObject();
                        test.put("RoomateRelatioships",num);
                        sxeseis.put(test);
                    }
                    for (int num : list_klados){

                        JSONObject test = new JSONObject();
                        test.put("Industries",num);
                        klados.put(test);
                    }

                    jsonParam.put("City", "");
                    jsonParam.put("UserId", "D768AXq0RWVjmWTSjFbn9611HLy2");

                    System.out.println("TE12"+group1int + group2int +group3int +group4int +group5int+group + group1 + group2);
                    jsonParam.put("Country", xora);
                    jsonParam.put("Education", group1int);
                    jsonParam.put("Gender", group2int);
                    jsonParam.put("Age", Integer.parseInt(age.getEditText().getText().toString()));
                    jsonParam.put("TK", tk);
                    jsonParam.put("FamilyStatus", group3int);
                    jsonParam.put("Work", group4int);
                    jsonParam.put("Roommates", Integer.parseInt(text2.getText().toString()));
                    jsonParam.put("FinancialStatus", group5int);


                    jsonParam.put("RoomateRelations", sxeseis);
                    jsonParam.put("Industries", klados);



System.out.println("EEEXD"+jsonParam.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Api.post("Account/Demographic",jsonParam.toString(),ta);



            }
        });
}
    public void onCheckboxClicked(View view) {


    }
    public enum CustomHotelClassification {
        ONE_STAR(1),
        TWO_STAR(2),
        THREE_STAR(3),
        FOUR_STAR(4),
        FIVE_STAR(5);
        private final int value;
        // NOTE: Enum constructor must have private or package scope. You can not use the public access
        // modifier.
        private CustomHotelClassification(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

    }}