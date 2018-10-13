package com.cdye.optionview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author cdy
 * @date 2018/10/13
 * @describe TODO
 */
public class OptionView extends ConstraintLayout {
    private ImageView ivIcon, ivArrow, ivImage;
    private TextView textView, textViewBottom, textViewRight;

    public OptionView(Context context) {
        super(context);
        init(context, null);
    }

    public OptionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_option_view, this);
        ivIcon = findViewById(R.id.icon);
        ivArrow = findViewById(R.id.arrow);
        ivImage = findViewById(R.id.imageView);
        textView = findViewById(R.id.text);
        textViewBottom = findViewById(R.id.text_bottom);
        textViewRight = findViewById(R.id.text_right);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionView);
            if (typedArray != null) {
                String text = typedArray.getString(R.styleable.OptionView_opt_text);
                String textBottom = typedArray.getString(R.styleable.OptionView_opt_text_bottom);
                String textRight = typedArray.getString(R.styleable.OptionView_opt_text_right);
                int textSize = typedArray.getDimensionPixelOffset(R.styleable.OptionView_opt_text_size, -1);
                int textBottomSize = typedArray.getDimensionPixelOffset(R.styleable.OptionView_opt_text_bottom_size, -1);
                int textRightSize = typedArray.getDimensionPixelOffset(R.styleable.OptionView_opt_text_right_size, -1);
                int textColor = typedArray.getColor(R.styleable.OptionView_opt_text_color, -1);
                int textBottomColor = typedArray.getColor(R.styleable.OptionView_opt_text_bottom_color, -1);
                int textRightColor = typedArray.getColor(R.styleable.OptionView_opt_text_right_color, -1);
                int iconWith = typedArray.getDimensionPixelSize(R.styleable.OptionView_opt_icon_width, -1);
                int iconHeight = typedArray.getDimensionPixelSize(R.styleable.OptionView_opt_icon_height, -1);
                int arrowWith = typedArray.getDimensionPixelSize(R.styleable.OptionView_opt_arrow_width, -1);
                int arrowHeight = typedArray.getDimensionPixelSize(R.styleable.OptionView_opt_arrow_height, -1);
                int imageWith = typedArray.getDimensionPixelSize(R.styleable.OptionView_opt_image_width, -1);
                int imageHeight = typedArray.getDimensionPixelSize(R.styleable.OptionView_opt_image_height, -1);
                Drawable icon = typedArray.getDrawable(R.styleable.OptionView_opt_icon);
                Drawable arrow = typedArray.getDrawable(R.styleable.OptionView_opt_arrow);
                Drawable image = typedArray.getDrawable(R.styleable.OptionView_opt_image);
                boolean isImageVisible = typedArray.getBoolean(R.styleable.OptionView_opt_image_visible, false);
                boolean isArrowVisible = typedArray.getBoolean(R.styleable.OptionView_opt_arrow_visible, true);
                boolean isIconVisible = typedArray.getBoolean(R.styleable.OptionView_opt_icon_visible, true);
                if (!TextUtils.isEmpty(text)) {
                    textView.setText(text);
                }
                if (!TextUtils.isEmpty(textBottom)) {
                    textViewBottom.setVisibility(VISIBLE);
                    textViewBottom.setText(textBottom);
                } else {
                    textViewBottom.setVisibility(GONE);
                }
                if (!TextUtils.isEmpty(textRight)) {
                    textViewRight.setVisibility(VISIBLE);
                    textViewRight.setText(textRight);
                } else {
                    textViewRight.setVisibility(GONE);
                }
                if (textSize != -1) {
                    textView.setTextSize(textSize);
                }
                if (textBottomSize != -1) {
                    textViewBottom.setTextSize(textBottomSize);
                }
                if (textRightSize != -1) {
                    textViewRight.setTextSize(textRightSize);
                }
                if (textColor != -1) {
                    textView.setTextColor(textColor);
                }
                if (textBottomColor != -1) {
                    textViewBottom.setTextColor(textBottomColor);
                }
                if (textRightColor != -1) {
                    textViewRight.setTextColor(textRightColor);
                }
                if (isIconVisible) {
                    ivIcon.setVisibility(VISIBLE);
                    if (iconWith != -1 && iconHeight != -1) {
                        ViewGroup.LayoutParams layoutParams = ivIcon.getLayoutParams();
                        layoutParams.width = iconWith;
                        layoutParams.height = iconHeight;
                        ivIcon.setLayoutParams(layoutParams);
                    }
                    if (icon != null) {
                        ivIcon.setImageDrawable(icon);
                    }

                } else {
                    ivIcon.setVisibility(GONE);
                }
                if (isArrowVisible) {
                    ivArrow.setVisibility(VISIBLE);
                    if (arrowWith != -1 && arrowHeight != -1) {
                        ViewGroup.LayoutParams layoutParams = ivArrow.getLayoutParams();
                        layoutParams.width = arrowWith;
                        layoutParams.height = arrowHeight;
                        ivArrow.setLayoutParams(layoutParams);
                    }
                    if (arrow != null) {
                        ivArrow.setImageDrawable(arrow);
                    }
                } else {
                    ivArrow.setVisibility(GONE);
                }
                if (isImageVisible) {
                    ivImage.setVisibility(VISIBLE);
                    if (imageWith != -1 && imageHeight != -1) {
                        ViewGroup.LayoutParams layoutParams = ivImage.getLayoutParams();
                        layoutParams.width = imageWith;
                        layoutParams.height = imageHeight;
                        ivImage.setLayoutParams(layoutParams);
                    }
                    if (image != null) {
                        ivImage.setImageDrawable(image);
                    }
                } else {
                    ivImage.setVisibility(GONE);
                }

                typedArray.recycle();
            }
        }


    }
}
