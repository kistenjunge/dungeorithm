package kistenjunge.org.dungeorithm.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Coordinate
{
  private final Integer x;

  private final Integer y;

  public Coordinate(Integer x, Integer y)
  {
    this.x = x;
    this.y = y;
  }

  public Integer getX()
  {
    return x;
  }

  public Integer getY()
  {
    return y;
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder(19, 81).
        append(x).
        append(y).
        toHashCode();
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null)
    {
      return false;
    }
    if (obj == this)
    {
      return true;
    }
    if (obj.getClass() != getClass())
    {
      return false;
    }

    Coordinate rhs = (Coordinate) obj;
    return new EqualsBuilder()
        .append(x, rhs.x)
        .append(y, rhs.y)
        .isEquals();
  }

}
