package com.example.vis360;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

public class Disclaimer extends AppCompatActivity {
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .8));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);

        message=(TextView)findViewById(R.id.disclaimer_message);
        message.setText("Η εφαρμογή Virus Information System “VIS 360” αποτελεί πρωτοβουλία του Εργαστηρίου Πληροφοριακών Συστημάτων / Κέντρο Έρευνας για την Ηλεκτρονική Διακυβέρνηση, και υλοποιείται για ερευνητικούς σκοπούς από ομάδες φοιτητών και διδασκόντων στα πλαίσια μαθημάτων του Τμήματος Πληροφοριακών και Επικοινωνιακών Συστημάτων του Πανεπιστημίου Αιγαίου.\n\nΤο Σύστημα Πληροφοριών για τον ΚορωνοΪό (VIS 360) είναι μια πλατφόρμα ευαισθητοποίησης της κοινότητας, αφιερωμένη στη συλλογή, την ανταλλαγή και τη στατιστική ανάλυση των πληροφοριών που προέρχονται από πολίτες σχετικά με την εξάπλωση του ιού COVID-19 στην Ελλάδα, προσφέροντας άποψη “360 μοιρών”, αντί της κοινής ανάλυσης από “πάνω προς τα κάτω”. Το VIS 360 λειτουργεί συμπληρωματικά προς τα επίσημα συστήματα και τις υπηρεσίες υγείας, στοχεύοντας στις πληροφορίες που εισάγουν οι πολίτες, οι επιχειρήσεις και οι οργανισμοί, με στόχο τη σημαντική μείωση της υπερφόρτωσης των πληροφοριών από τις αρχές του δημόσιου τομέα.  \n\nΔεδομένου ότι μέσω της εφαρμογής συλλέγονται και υπόκεινται σε επεξεργασία προσωπικά δεδομένα, ισχύει ο ευρωπαϊκός Γενικός Κανονισμός για την Προστασία Δεδομένων (GDPR) 2016/679. Η συμπλήρωση του ερωτηματολογίου είναι προαιρετική και μέσω της συμμετοχής σας δηλώνετε υπεύθυνα ότι συναινείτε στην επεξεργασία των προσωπικών σας δεδομένων. Η συλλογή και η επεξεργασία των απαντήσεων γίνεται σύμφωνα με τον ισχύοντα Νόμο περί ευαίσθητων δεδομένων (ΓΚΠΔ), βλ. Αρχή Προστασίας Δεδομένων Προσωπικού Χαρακτήρα (www.dpa.gr). Για ζητήματα προστασίας δεδομένων μπορείτε να απευθυνθείτε στον υπεύθυνο προστασίας δεδομένων για την εφαρμογή στο email dgrc@aegean.gr .  \n\nΤο VIS 360 είναι πλήρως συμβατό με τις αρχές GDPR, καθώς όλες οι προσωπικές, ευαίσθητες πληροφορίες συγκεντρώνονται με τη θετική συγκατάθεση των χρηστών και είναι επίσης κρυπτογραφημένες και προστατευμένες από όλους τους φορείς καθ 'όλη τη διάρκεια του κύκλου ζωής του συστήματος. Ο μηχανισμός ανάλυσης και οπτικοποίησης VIS 360 παρέχει μόνο συλλογικές, ανώνυμες πληροφορίες σχετικά με τις περιπτώσεις που συλλέγονται\n \n © 2020 Κέντρο Έρευνας για την Ηλεκτρονική Διακυβέρνηση / Πανεπιστήμιο Αιγαίου");
        message.setMovementMethod(new ScrollingMovementMethod());
    }
}
