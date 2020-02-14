import java.util.ArrayList;
import java.io.*;


//  stores a word and postings
class DictionaryWord {
  
  String word;
  
  ArrayList<Posting> postings = new ArrayList<Posting>();
  
  DictionaryWord(String w) {
    word = w;
  }
  
  void addPosting(Posting p) {
    postings.add(p);
  }
  
  //  returns the total occurances of the word in the document
  int totalOccurances() {
    int total = 0;
    for (Posting p : postings) {
      total += p.postings.length;
    }
    return total;
  }
  
  //  returns the total documents of the word in the document
  int totalDocuments() {
    return postings.size();
  }
}

//  class for storing postings
class Posting {
  
  int docID;
  int[] postings;
  
  Posting(int id, int[] p) {
    docID = id;
    postings = p;
  }
  
  void addPosting(int p) {
    int[] postings2 = new int[postings.length+1];
    for (int i = 0; i < postings.length; i++)
      postings2[i] = postings[i];
    postings2[postings.length] = p;
    postings = postings2;
  }
}