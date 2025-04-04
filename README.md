**DNA Pattern Detection Using Finite Automata**

Objective: Students will work in groups to design and implement a program that uses deterministic
finite automata (DFA) to find specific patterns in DNA sequences. The project aims to demonstrate the
practical application of finite automata in solving real-world problems such as those encountered in
bioinformatics.

Note: This project is a simulation intended for educational purposes and does not represent actual
diagnostic tools or medical advice.

Background Information: DNA sequences are strings composed of four nucleotides: Adenine (A),
Thymine (T), Cytosine (C), and Guanine (G). These sequences encode genetic information through
triplets of nucleotides called codons, where each codon corresponds to an amino acid or a signal during
protein synthesis. Key patterns in DNA sequences, such as motifs, start codons, or regulatory sequences,
play essential roles in biological processes. For example, the codon ATG signals the start of translation,
while specific sequences like CAG repeats and certain mutations can indicate diseases. Finite automata
provide an efficient way to detect such patterns by constructing a state machine that matches the
desired sequence.

Project Description: Each group will develop a program that implements a DFA to search for specific
patterns in a DNA sequence:
1. Start Codon Detection: The program must locate the codon ATG, which marks the beginning of
protein synthesis. If ATG is not found, the program should output a message stating, "Start
codon not found."
2. Huntington's Disease Gene Detection: After detecting ATG, the program must search for three
consecutive repetitions of CAG, signalling a Huntington's disease-related gene. Output:
"Huntington's disease gene found."
3. Possible Cancer Mutation Detection: If the codon GGT is followed by GAT, the program should
output: "Possible cancer mutation found."
Page 2 of 3
4. If neither CAG repeats nor the GGT-GAT pattern is found after detecting ATG, the program
should output: "No significant patterns found."
Requirements:
1. DFA Design:
o States: Create a state for each character in the target patterns and one start state.
o Transitions: Define transitions for each nucleotide (A, T, C, G) based on the current state
and character.
o Accept State: Define states where the full pattern is matched.
2. Algorithm:
o Traverse the DNA sequence character by character.
o Transition between DFA states based on the input nucleotide.
o Record the position whenever the DFA reaches an accept state.
3. Implementation:
Use any programming language to:
o Input the DNA sequence and the patterns.
o Construct the DFA dynamically based on the input pattern.
o Traverse the sequence and output the results.
4. Testing:
o Test the program with various DNA sequences and edge cases.
5. Optimization and Analysis:
o Analyse the time complexity of the DFA-based pattern matching (O(n)).
o Compare it to naive string matching (O(n * m), where m is the length of the pattern).
