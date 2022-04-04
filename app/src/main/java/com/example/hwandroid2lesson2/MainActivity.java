package com.example.hwandroid2lesson2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.hwandroid2lesson2.databinding.ActivityMainBinding;
import com.example.hwandroid2lesson2.fragments.adapter.AdapterOnBoard;
import com.example.hwandroid2lesson2.fragments.model.Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Model> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setData();
        setupScrollContent();
        setupListeners();
    }

    private void setupScrollContent() {
        //Не пришло в голову нужное слово, которое описывает действия метода
        // Метод заставляет работать самодельный "Dot's indicator" , а также
        // меняет текст кнопки про попадании на последний элемент
        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (position < list.size() - 1) {
                    binding.btnNext.setText("Дальше");
                } else binding.btnNext.setText("Начинаем");
                if (binding.pager.getCurrentItem() == position) {
                    for (int i = 0; i < list.size(); i++) {
                        if (i == position && position == 0) {
                            binding.imDot1.setImageResource(R.drawable.selected_dot);
                            binding.imDot2.setImageResource(R.drawable.default_dot);
                            binding.imDot3.setImageResource(R.drawable.default_dot);
                        } else if (i == position && position == 1) {
                            binding.imDot1.setImageResource(R.drawable.default_dot);
                            binding.imDot2.setImageResource(R.drawable.selected_dot);
                            binding.imDot3.setImageResource(R.drawable.default_dot);
                        } else if (i == position && position == 2) {
                            binding.imDot1.setImageResource(R.drawable.default_dot);
                            binding.imDot2.setImageResource(R.drawable.default_dot);
                            binding.imDot3.setImageResource(R.drawable.selected_dot);
                        }
                    }
                }

            }
        });
    }


    private void setData() {
        list.add(new Model("Экономь время", R.drawable.watch));
        list.add(new Model("Достигай целей", R.drawable.darts));
        list.add(new Model("Развивайся", R.drawable.earth));
        binding.pager.setAdapter(new AdapterOnBoard(list));
    }

    private void setupListeners() {

        // button listener
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.pager.getCurrentItem() <= list.size())
                    binding.pager.setCurrentItem(binding.pager.getCurrentItem() + 1);
            }
        });

        // dotsListeners
        binding.imDot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.pager.getCurrentItem() != 0) {
                    binding.pager.setCurrentItem(0);
                }
            }
        });
        binding.imDot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.pager.getCurrentItem() != 1) {
                    binding.pager.setCurrentItem(1);
                }
            }
        });
        binding.imDot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.pager.getCurrentItem() != 2) {
                    binding.pager.setCurrentItem(2);
                }
            }
        });
    }
}