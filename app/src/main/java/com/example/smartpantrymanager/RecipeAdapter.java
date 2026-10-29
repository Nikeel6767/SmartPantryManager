package com.example.smartpantrymanager;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class RecipeAdapter
        extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList;

    public RecipeAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);

        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecipeViewHolder holder,
            int position) {

        Recipe recipe = recipeList.get(position);

        String recipeName = recipe.getName();

        holder.tvRecipeName.setText(recipeName);

        holder.tvRecipeDescription.setText(
                recipe.getDescription()
        );

        int recipeColor = getRecipeColor(recipeName);

        holder.recipeColorAccent.setBackgroundColor(recipeColor);

        holder.tvRecipeName.setTextColor(recipeColor);

        holder.btnViewRecipe.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            v.getContext(),
                            RecipeDetailActivity.class
                    );

            intent.putExtra(
                    "recipe_id",
                    recipe.getId()
            );

            intent.putExtra(
                    "recipe_name",
                    recipe.getName()
            );

            intent.putExtra(
                    "recipe_description",
                    recipe.getDescription()
            );

            intent.putExtra(
                    "recipe_ingredients",
                    recipe.getIngredients()
            );

            intent.putExtra(
                    "recipe_instructions",
                    recipe.getInstructions()
            );

            v.getContext().startActivity(intent);
        });
    }

    private int getRecipeColor(String recipeName) {

        String name = recipeName.toLowerCase(Locale.ROOT);

        if (name.contains("tomato")) {
            return Color.parseColor("#212121");
        }

        if (name.contains("banana")) {
            return Color.parseColor("#424242");
        }

        if (name.contains("vegetable")) {
            return Color.parseColor("#555555");
        }

        if (name.contains("chicken")) {
            return Color.parseColor("#666666");
        }

        if (name.contains("tuna")) {
            return Color.parseColor("#757575");
        }

        if (name.contains("egg")) {
            return Color.parseColor("#333333");
        }

        if (name.contains("cheese")) {
            return Color.parseColor("#4A4A4A");
        }

        if (name.contains("toast")) {
            return Color.parseColor("#888888");
        }

        if (name.contains("pasta")) {
            return Color.parseColor("#999999");
        }

        return Color.parseColor("#000000");
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class RecipeViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvRecipeName;
        TextView tvRecipeDescription;
        Button btnViewRecipe;
        View recipeColorAccent;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRecipeName =
                    itemView.findViewById(
                            R.id.tvRecipeName
                    );

            tvRecipeDescription =
                    itemView.findViewById(
                            R.id.tvRecipeDescription
                    );

            btnViewRecipe =
                    itemView.findViewById(
                            R.id.btnViewRecipe
                    );

            recipeColorAccent =
                    itemView.findViewById(
                            R.id.recipeColorAccent
                    );
        }
    }
}