
package com.gsli.dr.domain.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.Attribute.PersistentAttributeType;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;

import com.gsli.dr.common.util.ObjectChecker;



public class ByEntityCriteriaHelper {
	public static <T> Specification<T> byEntity(final EntityManager em,
			final T example) {

		@SuppressWarnings("unchecked")
		final Class<T> type = (Class<T>) example.getClass();
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				EntityType<T> entity = em.getMetamodel().entity(type);
				for (Attribute<T, ?> attr : entity
						.getDeclaredSingularAttributes()) {
					if (attr.getPersistentAttributeType() == PersistentAttributeType.MANY_TO_ONE
							|| attr.getPersistentAttributeType() == PersistentAttributeType.ONE_TO_ONE) {
						continue;
					}

					Object attrValue = getValue(example, attr);
					if (attrValue != null) {
						if (attr.getJavaType() == String.class) {
							if (!ObjectChecker
									.isStringEmpty((String) attrValue)) {
								predicates.add(builder.like(
										root.get(attribute(entity,
												attr.getName(), String.class)),
										pattern((String) attrValue)));
							}
						} else {
							Predicate predicate = builder.equal(root
									.get(attribute(entity, attr.getName(),
											attrValue.getClass())), attrValue);
							predicates.add(predicate);
						}
					}
				}

				return predicates.isEmpty() ? builder.conjunction()
						: builder.and(predicates
								.toArray(new Predicate[predicates.size()]));
			}

			private Object getValue(T example, Attribute<T, ?> attr) {
				try {

					return ReflectionUtils.invokeMethod(
							(Method) attr.getJavaMember(), example);
				} catch (Exception e) {
					throw e;
				}
			}

			private <E> SingularAttribute<T, E> attribute(EntityType<T> entity,
					String fieldName, Class<E> fieldClass) {
				return entity.getDeclaredSingularAttribute(fieldName,
						fieldClass);
			}
		};
	}
	
	public static <T> Specification<T> byEntityCreatedBetween(final EntityManager em,
			final T example,final DateRange range) {

		@SuppressWarnings("unchecked")
		final Class<T> type = (Class<T>) example.getClass();
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				EntityType<T> entity = em.getMetamodel().entity(type);
				for (Attribute<T, ?> attr : entity
						.getDeclaredSingularAttributes()) {
					if (attr.getPersistentAttributeType() == PersistentAttributeType.MANY_TO_ONE
							|| attr.getPersistentAttributeType() == PersistentAttributeType.ONE_TO_ONE) {
						continue;
					}

					Object attrValue = getValue(example, attr);
					if (attrValue != null) {
						if (attr.getJavaType() == String.class) {
							if (!ObjectChecker
									.isStringEmpty((String) attrValue)) {
								predicates.add(builder.like(
										root.get(attribute(entity,
												attr.getName(), String.class)),
										pattern((String) attrValue)));
							}
						} else {
							Predicate predicate = builder.equal(root
									.get(attribute(entity, attr.getName(),
											attrValue.getClass())), attrValue);
							predicates.add(predicate);
						}
					}
				}
				if (range.isBetween()) {
					predicates.add(builder.between(root.get(entity
							.getSupertype().getSingularAttribute(
									range.getFieldName(), Date.class)), range
							.getFrom(), range.getTo()));
				}
				
				return predicates.isEmpty() ? builder.conjunction()
						: builder.and(predicates
								.toArray(new Predicate[predicates.size()]));
			}


			private Object getValue(T example, Attribute<T, ?> attr) {
				try {

					return ReflectionUtils.invokeMethod(
							(Method) attr.getJavaMember(), example);
				} catch (Exception e) {
					throw e;
				}
			}

			private <E> SingularAttribute<T, E> attribute(EntityType<T> entity,
					String fieldName, Class<E> fieldClass) {
				return entity.getDeclaredSingularAttribute(fieldName,
						fieldClass);
			}
		};
	}	

	/**
	 * Lookup entities having at least one String attribute matching the passed
	 * pattern.
	 */
	public static <T> Specification<T> byPatternOnStringAttributes(
			final EntityManager em, final String pattern, final Class<T> type) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<>();
				EntityType<T> entity = em.getMetamodel().entity(type);
				for (Attribute<T, ?> attr : entity
						.getDeclaredSingularAttributes()) {
					if (attr.getPersistentAttributeType() == PersistentAttributeType.MANY_TO_ONE
							|| attr.getPersistentAttributeType() == PersistentAttributeType.ONE_TO_ONE) {
						continue;
					}
					if (attr.getJavaType() == String.class
							&& ObjectChecker.isStringEmpty((pattern))) {
						predicates.add(builder.like(
								root.get(attribute(entity, attr)),
								pattern(pattern)));
					}
				}
				return predicates.isEmpty() ? builder.conjunction() : builder
						.or((Predicate[]) predicates.toArray());
			}

			private SingularAttribute<T, String> attribute(
					EntityType<T> entity, Attribute<T, ?> attr) {
				return entity.getDeclaredSingularAttribute(attr.getName(),
						String.class);
			}
		};
	}

	static private String pattern(String str) {
		return "%" + str + "%";
	}

	/**
	 * Lookup entities having at least one String attribute matching the passed
	 * pattern.
	 * @param <T>
	 */
	public static <T> List<Predicate> getPredicatesByPatternOnAttributes(final EntityManager em, final T example,
					Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) 
	{
		@SuppressWarnings("unchecked")
		final Class<T> type = (Class<T>) example.getClass();

		List<Predicate> predicates = new ArrayList<Predicate>();
		EntityType<T> entity = em.getMetamodel().entity(type);
		for (Attribute<T, ?> attr : entity
				.getDeclaredSingularAttributes()) {
			if (attr.getPersistentAttributeType() == PersistentAttributeType.MANY_TO_ONE
					|| attr.getPersistentAttributeType() == PersistentAttributeType.ONE_TO_ONE) {
				continue;
			}

			Object attrValue = getValue(example, attr);
			if (attrValue != null) {
				if (attr.getJavaType() == String.class) {
					if (!ObjectChecker
							.isStringEmpty((String) attrValue)) {
						predicates.add(builder.like(
								root.get(attribute(entity,
										attr.getName(), String.class)),
								pattern((String) attrValue)));
					}
				} else {
					Predicate predicate = builder.equal(root
							.get(attribute(entity, attr.getName(),
									attrValue.getClass())), attrValue);
					predicates.add(predicate);
				}
			}
		}

		return predicates;
	
	}
	
	@SuppressWarnings("unused")
	private static <T> SingularAttribute<T, String> attribute(EntityType<T> entity, Attribute<T, ?> attr) {
		return entity.getDeclaredSingularAttribute(attr.getName(),String.class);
	}
	
	private static<T> Object getValue(T example, Attribute<T, ?> attr) {
		try {
			return ReflectionUtils.invokeMethod((Method) attr.getJavaMember(), example);
		} catch (Exception e) {
			throw e;
		}
	}

	private static <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity,
			String fieldName, Class<E> fieldClass) {
		return entity.getDeclaredSingularAttribute(fieldName,fieldClass);
	}
	
}
