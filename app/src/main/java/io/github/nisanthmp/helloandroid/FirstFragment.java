package io.github.nisanthmp.helloandroid;

import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
    byte next_char = 0b00011010; //S

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
        if ((next_char & one) != 0) reader_button_1.setBackgroundColor(black);
        else reader_button_1.setBackgroundColor(white);

        Button reader_button_2 = view.findViewById(R.id.reader_button_2);
        if ((next_char & two) != 0) reader_button_2.setBackgroundColor(black);
        else reader_button_2.setBackgroundColor(white);

        Button reader_button_3 = view.findViewById(R.id.reader_button_3);
        if ((next_char & three) != 0) reader_button_3.setBackgroundColor(black);
        else reader_button_3.setBackgroundColor(white);

        Button reader_button_4 = view.findViewById(R.id.reader_button_4);
        if ((next_char & four) != 0) reader_button_4.setBackgroundColor(black);
        else reader_button_4.setBackgroundColor(white);

        Button reader_button_5 = view.findViewById(R.id.reader_button_5);
        if ((next_char & five) != 0) reader_button_5.setBackgroundColor(black);
        else reader_button_5.setBackgroundColor(white);

        Button reader_button_6 = view.findViewById(R.id.reader_button_6);
        if ((next_char & six) != 0) reader_button_6.setBackgroundColor(black);
        else reader_button_6.setBackgroundColor(white);

        return;
    }

    private void setDotsClickListeners(View view) {
        Button reader_button_1 = view.findViewById(R.id.reader_button_1);
        reader_button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((next_char & one) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
            }
        });

        Button reader_button_2 = view.findViewById(R.id.reader_button_2);
        reader_button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((next_char & two) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
            }
        });

        Button reader_button_3 = view.findViewById(R.id.reader_button_3);
        reader_button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((next_char & three) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
            }
        });

        Button reader_button_4 = view.findViewById(R.id.reader_button_4);
        reader_button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((next_char & four) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
            }
        });

        Button reader_button_5 = view.findViewById(R.id.reader_button_5);
        reader_button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((next_char & five) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
            }
        });

        Button reader_button_6 = view.findViewById(R.id.reader_button_6);
        reader_button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((next_char & six) != 0) {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                }
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
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setDotsColor(view);
        setDotsClickListeners(view);
        view.findViewById(R.id.reader_button_to_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
