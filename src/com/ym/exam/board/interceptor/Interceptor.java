package com.ym.exam.board.interceptor;

import com.ym.exam.board.vo.Rq;

public interface Interceptor {
  boolean run(Rq rq);
}
