package designpattern.proxy;

/**
 * Created by tangxm on 2016/8/22.
 * 代理模式：抽象主题，代理主题，真实主题。其中代理主题和真实主题均实现抽象主题，代理主题隐藏了真实主题，并扩展了
 * 真实主题
 */
public interface Subject {
  void request();
}
