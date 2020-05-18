package io.github.nisanthmp.helloandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ReadFragment extends Fragment {
    byte nextChar = 0b00011010; //S

    boolean[] touched = new boolean[6];
    InputModule inputModule = new InputModule();

    byte one = 0b00100000;
    byte two = 0b00010000;
    byte three = 0b00001000;
    byte four = 0b00000100;
    byte five = 0b00000010;
    byte six = 0b00000001;

    int black = 0xFF000000;
    int white = 0xFFFFFFFF;

    private void setDotsColor(View view) {
        Button reader_button_1 = view.findViewById(R.id.reader_button_1);
        if ((nextChar & one) != 0) reader_button_1.setBackgroundColor(black);
        else reader_button_1.setBackgroundColor(white);

        Button reader_button_2 = view.findViewById(R.id.reader_button_2);
        if ((nextChar & two) != 0) reader_button_2.setBackgroundColor(black);
        else reader_button_2.setBackgroundColor(white);

        Button reader_button_3 = view.findViewById(R.id.reader_button_3);
        if ((nextChar & three) != 0) reader_button_3.setBackgroundColor(black);
        else reader_button_3.setBackgroundColor(white);

        Button reader_button_4 = view.findViewById(R.id.reader_button_4);
        if ((nextChar & four) != 0) reader_button_4.setBackgroundColor(black);
        else reader_button_4.setBackgroundColor(white);

        Button reader_button_5 = view.findViewById(R.id.reader_button_5);
        if ((nextChar & five) != 0) reader_button_5.setBackgroundColor(black);
        else reader_button_5.setBackgroundColor(white);

        Button reader_button_6 = view.findViewById(R.id.reader_button_6);
        if ((nextChar & six) != 0) reader_button_6.setBackgroundColor(black);
        else reader_button_6.setBackgroundColor(white);

        return;
    }

    private boolean allTouched() {
        for (int i = 0; i < 6; i++) {
            if (touched[i] == false) return false;
        }
        return true;
    }

    void displayNextChar(View view) {
        try {
            Thread.sleep(400);
        } catch (Exception error) {
            Log.d("Exception", error.toString());
        }
        view.findViewById(R.id.reader_button_next).performClick();
    }

    private void setDotsClickListeners(final View fragmentView) {
        Button reader_button_1 = fragmentView.findViewById(R.id.reader_button_1);
        reader_button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((nextChar & one) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
                touched[0] = true;
                if (allTouched()) displayNextChar(fragmentView);
            }
        });

        Button reader_button_2 = fragmentView.findViewById(R.id.reader_button_2);
        reader_button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((nextChar & two) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
                touched[1] = true;
                if (allTouched()) displayNextChar(fragmentView);
            }
        });

        Button reader_button_3 = fragmentView.findViewById(R.id.reader_button_3);
        reader_button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((nextChar & three) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
                touched[2] = true;
                if (allTouched()) displayNextChar(fragmentView);
            }
        });

        Button reader_button_4 = fragmentView.findViewById(R.id.reader_button_4);
        reader_button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((nextChar & four) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
                touched[3] = true;
                if (allTouched()) displayNextChar(fragmentView);
            }
        });

        Button reader_button_5 = fragmentView.findViewById(R.id.reader_button_5);
        reader_button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((nextChar & five) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
                touched[4] = true;
                if (allTouched()) displayNextChar(fragmentView);
            }
        });

        Button reader_button_6 = fragmentView.findViewById(R.id.reader_button_6);
        reader_button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((nextChar & six) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
                touched[5] = true;
                if (allTouched()) displayNextChar(fragmentView);
            }
        });

        return;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read, container, false);
    }

    public void onViewCreated(@NonNull final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.reader_button_to_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewWrite) {
                viewWrite.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                try {
                    Thread.sleep(100);
                } catch (Exception error) {
                    Log.d("Exception", error.toString());
                }
                viewWrite.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                try {
                    Thread.sleep(100);
                } catch (Exception error) {
                    Log.d("Exception", error.toString());
                }
                viewWrite.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);

                NavHostFragment.findNavController(ReadFragment.this)
                        .navigate(R.id.action_ReadFragment_to_WriteFragment);
            }
        });

        view.findViewById(R.id.reader_button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewNext) {
                if(inputModule.isThereNextChar()) {
                    viewNext.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    try {
                        Thread.sleep(100);
                    } catch (Exception error) {
                        Log.d("Exception", error.toString());
                    }
                    viewNext.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    nextChar = inputModule.getNextChar();
                    for (int i = 0; i < 6; i++) {
                        touched[i] = false;
                    }
                    setDotsColor(view);
                } else {
                    view.findViewById(R.id.reader_button_to_write).performClick();
                }
            }
        });
        setDotsClickListeners(view);
        displayNextChar(view);
    }
}
