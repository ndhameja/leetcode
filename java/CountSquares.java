
// An Efficient method to count squares between
// a and b
class CountSquares {
    double countSquares(int a, int b)
    {
        return (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
    }
}

