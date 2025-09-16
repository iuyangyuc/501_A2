1. Which tool you used   
   Github Copilot

2. What prompt or query you gave   
   Add color to the UI elements and improve the layout
   
3. What you kept or discarded from the output   
   Kept the suggestions for improving color.
```
colors = CardDefaults.cardColors(
            containerColor = if (isToggled)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceVariant
        )
```
And
```
            color = if (isToggled)
                MaterialTheme.colorScheme.onPrimaryContainer
            else
                MaterialTheme.colorScheme.onSurfaceVariant
        )
```