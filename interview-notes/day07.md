Notice how the mindset changes with each algorithm:

Bubble Sort: "Keep swapping until the largest reaches the end."
Selection Sort: "Find the minimum and place it correctly."
Insertion Sort: "Take one element and insert it into the already sorted part."

Bubble vs Selection vs Insertion
Feature	Bubble	Selection	Insertion
Main Idea	Swap adjacent elements	Select minimum	Insert each element in sorted part
Swaps	Many	One per pass	Uses shifting instead of repeated swaps
Stable	✅	❌	✅
Adaptive	✅	❌	✅
Best Case	O(n)	O(n²)	O(n)
Worst Case	O(n²)	O(n²)	O(n²)