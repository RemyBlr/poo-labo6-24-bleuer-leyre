package calculator;
import calculator.State;

abstract class Operator
{
  protected State state;

  public Operator(State state)
  {
    this.state = state;
  }

  abstract void execute();
}
