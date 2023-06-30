**Title: Prediction of CUI of Medical Terms based on the Database of all Medical Concepts (UMLS)**

Introduction:
The goal of this project is to develop a system that can predict the Concept Unique Identifier (CUI) for medical terms based on the Unified Medical Language System (UMLS) database. The system will handle medical terms from different domains, containing over 100 source vocabularies, including MeSH (Medical sub Heading) concepts related to anatomy, biology, physiology, organisms, diseases, and chemicals.

UMLS Concepts and Identifiers:
The UMLS consists of various levels of concept identification, including:

Concept (>1M): A set of synonymous concept names.
Term (>3.8M): Represents a set of normalized names.
String (>4.3M): Represents distinct concept names.
Atom (>5.1M): Concept name in a given source, identified by a unique Atom Unique Identifier (AUI).

Concepts and their Identifiers:
For each occurrence of a string in a source, there is a corresponding AUI. Any variation in character set, case, or punctuation results in a separate string, represented by a String Unique Identifier (SUI). Each string is linked to all its variants through a unique Term Unique Identifier (LUI). Each concept is identified by a unique Concept Unique Identifier (CUI), which depends on the context and source.

Example:
Taking the example of the term "cold," it may have more than one concept in the Metathesaurus:

Cold → A4711832 → S0026353 → L0009264 → C0009264 (SNOMEDCT)
Cold → A2880095 → S0026353 → L0009264 → C0009443 (SNOMEDCT)


Analysis and Current System Implementation:
The current system has been implemented using the Vector Space Model (VSM) with cosine similarity. A set of documents is created, pivoted around the concepts of medical terms. Terms referring to the same medical concept are grouped into the same document, and the document name is the CUI-id of the concept. The system aims to find the most similar document to a given medical term query based on word and context, leading to the prediction of the corresponding CUI.

Examples:
For the CUI "C0001973" representing Alcoholism, examples of related terms include alcoholism/alcohol abuse, addiction, chronic alcoholism, and intoxication, chronic alcoholic. Similarly, for the CUI "C0002395" representing Alzheimer Disease, related terms include Alzheimer's Disease, DAT, DEMENTIA OF THE ALZHEIMER TYPE, and Syndrome, Alzheimer.

Conclusion:
The prediction of CUI for medical terms using the UMLS database is a valuable task in the field of healthcare and information retrieval. By leveraging concepts, identifiers, and document similarity, the developed system can enhance the understanding and classification of medical terms, contributing to improved medical knowledge management.


LIMITATIONS OF THIS APPROACH:

With the given query, the system aims to output the most similar query, which may or may not be an exact match. This prediction is based on the Unified Medical Language System (UMLS) feature. It is important to note that a single medical entity can relate to more than one Concept Unique Identifier (CUI) within the UMLS database.

Details of system:

Start: Main.java

A11_File_Modify.java : Code to modify lemma file a/q to requirement, Separating Document and making separate document a/q to problem type.

B11_Extract_sui.java : Extracting SUI from corresponding lemma

C11_Nove_8.java : Calculation of cosine from SUI extracted file	

A21_Extract_SUI.java : Extracting only those SUI whose entities are present in Test file from different files, Frequency Rank file, CUI Rank file, and TUI Type Rank.

C21_Rabk1andRank2Scoring.java : Combining Rank1 aND rANK2 scoring

D21_Rank3Score.java: Creation of Rank3 

E21_Rank123.java : Combining Rank 1, 2, and 3.

F21_Entity_to_cui.java : Final system

G21_Accuracy_check.java: Accuracy check of the model.
