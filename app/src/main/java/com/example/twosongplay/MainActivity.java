package com.example.twosongplay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2;
    private SeekBar seekBar1,seekBar2;
    private MediaPlayer mediaPlayer1,mediaPlayer2;
    private TextView textView1,textView2;
    int f1;
    int f2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        seekBar1=findViewById(R.id.seekBar1);
        seekBar2=findViewById(R.id.seekBar2);
        mediaPlayer1=MediaPlayer.create(this,R.raw.astagfirullah);
        mediaPlayer2=MediaPlayer.create(this,R.raw.picasso);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer1.isPlaying()) {
                    button1.setText("Play");

                    mediaPlayer1.pause();
                }else{
                    button1.setText("Pause");
                    mediaPlayer1.start();


                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer2.isPlaying()){

                    button2.setText("Play");
                    mediaPlayer2.pause();

                }else{
                    button2.setText("Pause");
                    mediaPlayer2.start();



                }
            }
        });

        seekBar1.setMax(mediaPlayer1.getDuration());
        seekBar2.setMax(mediaPlayer2.getDuration());

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                mediaPlayer1.seekTo(progress);}
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer2.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}