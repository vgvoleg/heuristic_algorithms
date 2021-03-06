package com.vgvoleg.heuristic.algorithms.populational.genetic;

import com.vgvoleg.heuristic.problems.base.OptimizationProblem;

import static com.vgvoleg.heuristic.util.Generator.uniformDistribution;

class Mutation {

    interface Strategy {
        double[][] execute(double[][] population, OptimizationProblem problem);
    }

    static Strategy RANDOM = (population, problem) -> {
        boolean flag = true;
        int i = 0;
        while (flag) {
            i %= problem.getDimension();
            if (uniformDistribution(0, 1) < 1.0 / problem.getDimension()) {
                population[0][i] = uniformDistribution(problem.getLeftEdge(i), problem.getRightEdge(i));
                flag = false;
            }
            i++;
        }
        flag = true;
        i = 0;
        while (flag) {
            i %= problem.getDimension();
            if (uniformDistribution(0, 1) < 1.0 / problem.getDimension()) {
                population[1][i] = uniformDistribution(problem.getLeftEdge(i), problem.getRightEdge(i));
                flag = false;
            }
            i++;
        }
        return population;
    };

    static Strategy IRREGULAR = (population, problem) -> {
        // TODO: add realisation
        return null;
    };

    private Mutation() {
    }
}
