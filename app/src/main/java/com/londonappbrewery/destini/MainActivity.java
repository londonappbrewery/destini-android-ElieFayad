package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    int mIndex;//to keep track of the story
    private TextView mStoryTextView;//tells the story
    private TextView mUserPrompt;
    private Button mTopButton;//choice #1
    private Button mBottomButton;//choice #2


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mUserPrompt = (TextView) findViewById(R.id.userPrompt);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);
        mIndex = 1;

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTop();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBottom();
            }
        });

    }

    private void updateAtEnd(){//update when arrived at the end of the story (hide buttons and change the text of the user prompt)
        mTopButton.setVisibility(View.GONE);
        mBottomButton.setVisibility(View.GONE);
        mUserPrompt.setText(R.string.end);
    }

    private void updateTop(){//when choice #1 is selected go to the corresponding storyline according to mIndex
        switch(mIndex){
            case 1: case 2:mStoryTextView.setText(R.string.T3_Story);
                           mTopButton.setText(R.string.T3_Ans1);
                           mBottomButton.setText(R.string.T3_Ans2);
                           mIndex=3;
                           break;
            case 3:mStoryTextView.setText(R.string.T6_End);
                   updateAtEnd();
                   mIndex=6;
                   break;
        }

    }

    private void updateBottom(){//when choice #2 is selected go to the corresponding storyline according to mIndex
        switch (mIndex) {
            case 1: mStoryTextView.setText(R.string.T2_Story);
                    mTopButton.setText(R.string.T2_Ans1);
                    mBottomButton.setText(R.string.T2_Ans2);
                    mIndex = 2;
                    break;
            case 2: mStoryTextView.setText(R.string.T4_End);
                    updateAtEnd();
                    mIndex = 4;
                    break;
            case 3: mStoryTextView.setText(R.string.T5_End);
                    updateAtEnd();
                    mIndex = 5;
                    break;
        }
    }
}
