package calculator;
import calculator.State;

/**
 * Operator is an abstract class that represents an operator in the calculator.
 *
 * @author Arnaut Leyre
 * @author Rémy Bleuer
 */
abstract class Operator
{
  protected State state;

  public Operator(State state)
  {
    this.state = state;
  }

  /**
   * Executes the operator.
   */
  abstract void execute();
}
