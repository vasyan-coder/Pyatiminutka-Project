package com.example.pyatiminutka.Models.DataBase;

import android.app.Activity;
import android.content.Context;

import com.example.pyatiminutka.R;

public class QuestionTest extends Activity {

    public static int[] Question_title = {R.string.text_thermodynamics
    };

    public int[][][] QuestionTest = {
            {//Первый тест
                    {
                            R.string.test1_easy_q1,
                            R.string.test1_easy_q2,
                            R.string.test1_easy_q3,
                            R.string.test1_easy_q4,
                            R.string.test1_easy_q5,
                            R.string.test1_easy_q6,
                            R.string.test1_easy_q7,
                            R.string.test1_easy_q8,
                            R.string.test1_easy_q9,
                            R.string.test1_easy_q10,
                    },
                    {
                            R.string.test1_medium_q1,
                            R.string.test1_medium_q2,
                            R.string.test1_medium_q3,
                            R.string.test1_medium_q4,
                            R.string.test1_medium_q5,
                            R.string.test1_medium_q6,
                            R.string.test1_medium_q7,
                            R.string.test1_medium_q8,
                            R.string.test1_medium_q9,
                            R.string.test1_medium_q10,
                    },
                    {
                            R.string.test1_hard_q1,
                            R.string.test1_hard_q2,
                            R.string.test1_hard_q3,
                            R.string.test1_hard_q4,
                            R.string.test1_hard_q5,
                            R.string.test1_hard_q6,
                            R.string.test1_hard_q7,
                            R.string.test1_hard_q8,
                            R.string.test1_hard_q9,
                            R.string.test1_hard_q10,
                    }
            }
    };

    public int[][][][] choiceans = {
            {
                    { //Первый тест
                            //Лёгкий уровень сложности
                            {
                                    R.string.test1_easy_q1_ch1,
                                    R.string.test1_easy_q1_ch2,
                                    R.string.test1_easy_q1_ch3,
                                    R.string.test1_easy_q1_ch4
                            },
                            {
                                    R.string.test1_easy_q2_ch1,
                                    R.string.test1_easy_q2_ch2,
                                    R.string.test1_easy_q2_ch3,
                                    R.string.test1_easy_q2_ch4
                            },
                            {
                                    R.string.test1_easy_q3_ch1,
                                    R.string.test1_easy_q3_ch2,
                                    R.string.test1_easy_q3_ch3,
                                    R.string.test1_easy_q3_ch4
                            },
                            {
                                    R.string.test1_easy_q4_ch1,
                                    R.string.test1_easy_q4_ch2,
                                    R.string.test1_easy_q4_ch3,
                                    R.string.test1_easy_q4_ch4
                            },
                            {
                                    R.string.test1_easy_q5_ch1,
                                    R.string.test1_easy_q5_ch2,
                                    R.string.test1_easy_q5_ch3,
                                    R.string.test1_easy_q5_ch4
                            },
                            {
                                    R.string.test1_easy_q6_ch1,
                                    R.string.test1_easy_q6_ch2,
                                    R.string.test1_easy_q6_ch3,
                                    R.string.test1_easy_q6_ch4
                            },
                            {
                                    R.string.test1_easy_q7_ch1,
                                    R.string.test1_easy_q7_ch2,
                                    R.string.test1_easy_q7_ch3,
                                    R.string.test1_easy_q7_ch4
                            },
                            {
                                    R.string.test1_easy_q8_ch1,
                                    R.string.test1_easy_q8_ch2,
                                    R.string.test1_easy_q8_ch3,
                                    R.string.test1_easy_q8_ch4
                            },
                            {
                                    R.string.test1_easy_q9_ch1,
                                    R.string.test1_easy_q9_ch2,
                                    R.string.test1_easy_q9_ch3,
                                    R.string.test1_easy_q9_ch4
                            },
                            {
                                    R.string.test1_easy_q10_ch1,
                                    R.string.test1_easy_q10_ch2,
                                    R.string.test1_easy_q10_ch3,
                                    R.string.test1_easy_q10_ch4
                            }
                    },
                    {
                            //Средний уровень сложности
                            {
                                    R.string.test1_medium_q1_ch1,
                                    R.string.test1_medium_q1_ch2,
                                    R.string.test1_medium_q1_ch3,
                                    R.string.test1_medium_q1_ch4
                            },
                            {
                                    R.string.test1_medium_q2_ch1,
                                    R.string.test1_medium_q2_ch2,
                                    R.string.test1_medium_q2_ch3,
                                    R.string.test1_medium_q2_ch4
                            },
                            {
                                    R.string.test1_medium_q3_ch1,
                                    R.string.test1_medium_q3_ch2,
                                    R.string.test1_medium_q3_ch3,
                                    R.string.test1_medium_q3_ch4
                            },
                            {
                                    R.string.test1_medium_q4_ch1,
                                    R.string.test1_medium_q4_ch2,
                                    R.string.test1_medium_q4_ch3,
                                    R.string.test1_medium_q4_ch4
                            },
                            {
                                    R.string.test1_medium_q5_ch1,
                                    R.string.test1_medium_q5_ch2,
                                    R.string.test1_medium_q5_ch3,
                                    R.string.test1_medium_q5_ch4
                            },
                            {
                                    R.string.test1_medium_q6_ch1,
                                    R.string.test1_medium_q6_ch2,
                                    R.string.test1_medium_q6_ch3,
                                    R.string.test1_medium_q6_ch4
                            },
                            {
                                    R.string.test1_medium_q7_ch1,
                                    R.string.test1_medium_q7_ch2,
                                    R.string.test1_medium_q7_ch3,
                                    R.string.test1_medium_q7_ch4
                            },
                            {
                                    R.string.test1_medium_q8_ch1,
                                    R.string.test1_medium_q8_ch2,
                                    R.string.test1_medium_q8_ch3,
                                    R.string.test1_medium_q8_ch4
                            },
                            {
                                    R.string.test1_medium_q9_ch1,
                                    R.string.test1_medium_q9_ch2,
                                    R.string.test1_medium_q9_ch3,
                                    R.string.test1_medium_q9_ch4
                            },
                            {
                                    R.string.test1_medium_q10_ch1,
                                    R.string.test1_medium_q10_ch2,
                                    R.string.test1_medium_q10_ch3,
                                    R.string.test1_medium_q10_ch4
                            }
                    },
                    {
                            //Высокий уровень сложности
                            {
                                    R.string.test1_hard_q1_ch1,
                                    R.string.test1_hard_q1_ch2,
                                    R.string.test1_hard_q1_ch3,
                                    R.string.test1_hard_q1_ch4
                            },
                            {
                                    R.string.test1_hard_q2_ch1,
                                    R.string.test1_hard_q2_ch2,
                                    R.string.test1_hard_q2_ch3,
                                    R.string.test1_hard_q2_ch4
                            },
                            {
                                    R.string.test1_hard_q3_ch1,
                                    R.string.test1_hard_q3_ch2,
                                    R.string.test1_hard_q3_ch3,
                                    R.string.test1_hard_q3_ch4
                            },
                            {
                                    R.string.test1_hard_q4_ch1,
                                    R.string.test1_hard_q4_ch2,
                                    R.string.test1_hard_q4_ch3,
                                    R.string.test1_hard_q4_ch4
                            },
                            {
                                    R.string.test1_hard_q5_ch1,
                                    R.string.test1_hard_q5_ch2,
                                    R.string.test1_hard_q5_ch3,
                                    R.string.test1_hard_q5_ch4
                            },
                            {
                                    R.string.test1_hard_q6_ch1,
                                    R.string.test1_hard_q6_ch2,
                                    R.string.test1_hard_q6_ch3,
                                    R.string.test1_hard_q6_ch4
                            },
                            {
                                    R.string.test1_hard_q7_ch1,
                                    R.string.test1_hard_q7_ch2,
                                    R.string.test1_hard_q7_ch3,
                                    R.string.test1_hard_q7_ch4
                            },
                            {
                                    R.string.test1_hard_q8_ch1,
                                    R.string.test1_hard_q8_ch2,
                                    R.string.test1_hard_q8_ch3,
                                    R.string.test1_hard_q8_ch4
                            },
                            {
                                    R.string.test1_hard_q9_ch1,
                                    R.string.test1_hard_q9_ch2,
                                    R.string.test1_hard_q9_ch3,
                                    R.string.test1_hard_q9_ch4
                            },
                            {
                                    R.string.test1_hard_q10_ch1,
                                    R.string.test1_hard_q10_ch2,
                                    R.string.test1_hard_q10_ch3,
                                    R.string.test1_hard_q10_ch4
                            }
                    }
            }
    };

    public final int[][][][] correctAnswer = {

            {
                    //Первый тест
                    //Ответы на лёгкий уровень сложности
                    {
                            {0, 0, 1, 0}, //1
                            {1, 0, 0, 0}, //2
                            {0, 0, 1, 0}, //3
                            {0, 1, 0, 0}, //4
                            {0, 1, 0, 0}, //5
                            {1, 0, 0, 0}, //6
                            {0, 1, 0, 0}, //7
                            {0, 1, 0, 0}, //8
                            {0, 1, 0, 0}, //9
                            {0, 0, 1, 0}, //10
                    },
                    //Ответы на средний уровень сложности
                    {
                            {0, 0, 0, 1},
                            {1, 0, 0, 0},
                            {0, 1, 0, 0},
                            {0, 0, 0, 1},
                            {0, 1, 0, 0},
                            {1, 0, 0, 0},
                            {0, 1, 0, 0},
                            {0, 0, 1, 0},
                            {1, 0, 0, 0},
                            {0, 0, 1, 0}
                    },
                    //Ответы на высокий уровень сложности
                    {
                            {0, 1, 0, 0},
                            {1, 0, 0, 0},
                            {0, 1, 0, 0},
                            {0, 0, 1, 0},
                            {1, 0, 0, 0},
                            {1, 0, 0, 0},
                            {0, 1, 0, 0},
                            {0, 0, 0, 1},
                            {1, 0, 0, 0},
                            {0, 1, 0, 0}
                    }
            }
    };

    public static int[][][] test_pictures = {
            { //1 тест
                    { //лёгкая сложность
                            0,0,0,0,0,0,0,0,0,0
                    },
                    { //средняя сложность
                            0,0,0,0,R.drawable.ic_chart_term_medium_q5,0,0,0,0,0
                    },
                    { //высокая сложность
                            0,0,0,0,0,0,0,0,0,0
                    }
            }

    };

    public static int[] results = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    public static int[] incorrect_results = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    public static int[] choosed_answers1 = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    public static int[] choosed_answers2 = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    public static int[] choosed_answers3 = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    public static int[] choosed_answers4 = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static int[] skip_answers = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
}
