package com.example.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution_149 {
    public static void main(String[] args) {
        Solution_149 solution = new Solution_149();
        solution.mySolution_1(new int[][]{
                {0, 0}, {94911151, 94911150}, {94911152, 94911151}
        });
        int a = solution.tadR_3(15, 25);
        int b = solution.tadR_3(-15, 25);
        int c = solution.tadR_3(-15, -25);
        a = b;
    }

    public int maxPoints(int[][] points) {
        return 1;
    }

    // 浮点数有精度问题，不通过
    public int mySolution_1(int[][] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int[] start;
        int res = 0;
        Map<Fraction, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            start = points[i];
            int tempX = 1;
            int tempY = 1;
            int tempZ = 1;
            int repeat = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] - start[0] != 0 && points[j][1] - start[1] != 0) {
                    Fraction fraction = new Fraction(points[j][1] - start[1], points[j][0] - start[0]);
                    map.put(fraction, map.getOrDefault(fraction, 1) + 1);
                    tempZ = Math.max(map.get(fraction), tempZ);
                } else if (points[j][0] - start[0] == 0 && points[j][1] - start[1] != 0) {
                    tempX++;
                } else if (points[j][0] - start[0] != 0 && points[j][1] - start[1] == 0) {
                    tempY++;
                } else {
                    repeat++;
                }
            }
            map.clear();
            res = Math.max(res, Math.max(Math.max(tempX, tempY), tempZ) + repeat);
        }
        return res;
    }

    public int mySolution_2(int[][] points) {
        return 1;
    }


    public int tad_1(int a, int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    // 辗转相除
    public int tadR_1(int a, int b) {
        int c = a % b;
        if (c != 0) {
            return tadR_1(b, c);
        }
        return b;
    }

    public int tad_2(int a, int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    public int tadR_2(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return tadR_2(a - b, b);
        } else {
            return tadR_2(b - a, a);
        }
    }

    // 奇数偶数法结合更相减损
    public int tadR_3(int a, int b) {
        if (a < 0 || b < 0) {
            return tadR_3(Math.abs(a), Math.abs(b));
        }
        if (a == b) {
            return a;
        }
        if (a < b) {
            return tadR_3(b, a);
        }
        if (((a & 1) == 0) && ((b & 1) == 0)) {
            return tadR_3(a >> 1, b >> 1) << 1;
        } else if (((a & 1) == 0) && ((b & 1) != 0)) {
            return tadR_3(a >> 1, b);
        } else if (((a & 1) != 0) && ((b & 1) == 0)) {
            return tadR_3(a, b >> 1);
        } else {
            return tadR_3(a - b, b);
        }
    }

    static class Fraction {
        int molecule;
        int denominator;

        public Fraction(int m, int d) {
            int approximation = tadR_3(m, d);
            molecule = m / approximation;
            denominator = d / approximation;
            if ((molecule < 0 && denominator < 0) || (molecule > 0 && denominator < 0)) {
                molecule = -molecule;
                denominator = -denominator;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return molecule == fraction.molecule &&
                    denominator == fraction.denominator;
        }

        @Override
        public int hashCode() {
            return Objects.hash(molecule, denominator);
        }

        private int tadR_3(int a, int b) {
            if (a < 0 || b < 0) {
                return tadR_3(Math.abs(a), Math.abs(b));
            }
            if (a == b) {
                return a;
            }
            if (a < b) {
                return tadR_3(b, a);
            }
            if (((a & 1) == 0) && ((b & 1) == 0)) {
                return tadR_3(a >> 1, b >> 1) << 1;
            } else if (((a & 1) == 0) && ((b & 1) != 0)) {
                return tadR_3(a >> 1, b);
            } else if (((a & 1) != 0) && ((b & 1) == 0)) {
                return tadR_3(a, b >> 1);
            } else {
                return tadR_3(a - b, b);
            }
        }
    }
}
