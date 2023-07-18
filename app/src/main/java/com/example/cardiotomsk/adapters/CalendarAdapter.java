package com.example.cardiotomsk.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cardiotomsk.R;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {

   private ArrayList<String> daysOfMonth;

   class CalendarViewHolder extends RecyclerView.ViewHolder {
      TextView dayOfMonth;

      CalendarViewHolder(View itemView) {
         super(itemView);
         dayOfMonth = itemView.findViewById(R.id.calendarDayText);

      }
   }

   public CalendarAdapter(ArrayList<String> daysOfMonth){
      this.daysOfMonth = daysOfMonth;
   }

   @Override
   public int getItemCount() {
      return daysOfMonth.size();
   }

   @Override
   public long getItemId(int position) {
      return position;
   }

   @Override
   public CalendarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_calendar, viewGroup, false);
      ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
      layoutParams.height = (int) (viewGroup.getHeight() * 0.166666666);
      return new CalendarViewHolder(v);
   }

   @Override
   public void onBindViewHolder(CalendarViewHolder holder, int position) {
      holder.dayOfMonth.setText(daysOfMonth.get(position));


//      holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View v) {
//
//         }
//      });
   }

   @Override
   public void onAttachedToRecyclerView(RecyclerView recyclerView) {
      super.onAttachedToRecyclerView(recyclerView);
   }
}

