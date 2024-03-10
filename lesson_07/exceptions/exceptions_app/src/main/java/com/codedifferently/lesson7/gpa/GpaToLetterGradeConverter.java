package com.codedifferently.lesson7.gpa;

import com.codedifferently.lesson7.util.LinkedListNode;

/** An object that converts GPAs to their letter grade equivalent. */
public class GpaToLetterGradeConverter {

  private LinkedListNode<GpaLetterGradeMapping> head;

  public GpaToLetterGradeConverter() {
    this.head = new LinkedListNode<GpaLetterGradeMapping>(new GpaLetterGradeMapping(0, 1, "F"));

    var current = this.head;
    current.next =
        new LinkedListNode<GpaLetterGradeMapping>(new GpaLetterGradeMapping(1, 1.3, "D"));

    current = current.next;
    current.next =
        new LinkedListNode<GpaLetterGradeMapping>(new GpaLetterGradeMapping(1.3, 1.7, "D+"));

    // TODO(you): Finish configuring the linked list.
  }

  /**
   * Converts a GPA on the 4.0 scale to the corresponding letter grade using the college board
   * scale. See
   * https://bigfuture.collegeboard.org/plan-for-college/college-basics/how-to-convert-gpa-4.0-scale
   * for details.
   *
   * @param gpa The GPA value.
   * @return The letter grade ("A+", "A", "A-", "B+", etc.).
   */
  public String convertToLetterGrade(double gpa) throws IllegalArgumentException {
    throw new UnsupportedOperationException();
  }
}

/** An object that represents the mapping between a GPA range and a grade letter. */
class GpaLetterGradeMapping {
  public double minGpaInclusive;
  public double maxGpaExclusive;
  public String gradeLetter;

  public GpaLetterGradeMapping(double minGpaInclusive, double maxGpaExclusive, String gradeLetter) {
    this.minGpaInclusive = minGpaInclusive;
    this.maxGpaExclusive = maxGpaExclusive;
    this.gradeLetter = gradeLetter;
  }

  public boolean includesGpa(double gpa) {
    throw new UnsupportedOperationException();
  }

  public String getLetterGrade() {
    throw new UnsupportedOperationException();
  }
}
